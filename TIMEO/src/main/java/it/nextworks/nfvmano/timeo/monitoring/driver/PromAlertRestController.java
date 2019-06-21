package it.nextworks.nfvmano.timeo.monitoring.driver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.libs.common.enums.ThresholdCrossingDirection;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.ThresholdCrossedNotification;
import it.nextworks.nfvmano.timeo.monitoring.MonitoringAlertDispatcher;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusAlert;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusAlertMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marco Capitani on 20/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
@RestController
@RequestMapping(value = "/timeo/alerts")
public class PromAlertRestController {

    private static Logger log = LoggerFactory.getLogger(PromAlertRestController.class);

    private MonitoringAlertDispatcher dispatcher;

    private ObjectMapper mapper;

    @Autowired
    public PromAlertRestController(MonitoringAlertDispatcher dispatcher, ObjectMapper mapper) {
        this.dispatcher = dispatcher;
        this.mapper = mapper;
    }

    private void printData(Object data) throws JsonProcessingException {
        log.debug("Alert content:\n{}", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
    }

    private ThresholdCrossedNotification parseAlert(PrometheusAlert alert) throws JsonProcessingException {
        String alertname = alert.getLabels().get("alertname");
        if (alertname == null) {
            log.error("Malformed alert: no alertname label");
            printData(alert);
            throw new MalformedException();
        }
        String status = alert.getStatus();
        if (status == null || !(status.equals("firing") || status.equals("resolved"))) {
            log.error("Illegal alert status: {}", status);
            printData(alert);
            throw new MalformedException();
        }
        ThresholdCrossingDirection direction;
        // TODO: This is used as "firing", "resolved" as opposed to "growing" and "decreasing"...
        if (status.equals("firing")) {
            direction = ThresholdCrossingDirection.UP;
        } else {
            direction = ThresholdCrossingDirection.DOWN;
        }
        return new ThresholdCrossedNotification(
                alertname,
                direction,
                null,  // TODO: values here? What? They are unused...
                null,
                0
        );
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void notify(@RequestBody PrometheusAlertMessage notification) {
        log.info("Received alert");
        try {
            // debug info
            printData(notification);
            // Parse, validate and convert
            for (PrometheusAlert alert : notification.getAlerts()) {
                ThresholdCrossedNotification ifaAlert = parseAlert(alert);
                dispatcher.notify(ifaAlert);
            }
        } catch (JsonProcessingException exc) {
            log.error("Cannot process JSON payload");
            log.debug("Details:", exc);
            throw new MalformedException();
        }
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "video not found")
    private class MalformedException extends RuntimeException {
    }
}
