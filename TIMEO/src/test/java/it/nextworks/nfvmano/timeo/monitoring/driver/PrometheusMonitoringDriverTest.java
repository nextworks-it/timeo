package it.nextworks.nfvmano.timeo.monitoring.driver;

import io.swagger.client.model.AlertDescription;
import it.nextworks.nfvmano.libs.common.enums.RelationalOperation;
import it.nextworks.nfvmano.libs.common.enums.ThresholdType;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.PmJob;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusTDetails;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Marco Capitani on 24/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class PrometheusMonitoringDriverTest {

    private PrometheusMonitoringDriver driver;

    @Before
    public void setup() {
        driver = new PrometheusMonitoringDriver(
                null,
                null,
                null,
                "http://timeo.nextworks.it/"
        );
    }

    @Test
    public void makeAlertQuery() {
        driver.storePmJobInfo(
                new PmJob(
                        "pmJob",
                        null,
                        null,
                        null,
                        15,
                        10,
                        ""
                ),
                "expId",
                "vnfId"
        );
        CreateThresholdRequest request = new CreateThresholdRequest(
                null,
                null,
                null,
                "CurrentActiveClientConnections",
                ThresholdType.SINGLE_VALUE,
                new PrometheusTDetails(
                        42,
                        RelationalOperation.GE,
                        12,
                        "pmJob"
                )
        );
        AlertDescription alertDescription = driver.makeAlertDescription(request);

        assertEquals("12s", alertDescription.getFor());
        assertEquals(AlertDescription.KindEnum.GEQ, alertDescription.getKind());
        assertEquals("trafficserver_stats_http_current_active_client_connections{job=\"expId\"}", alertDescription.getQuery());
        assertEquals(AlertDescription.SeverityEnum.WARNING, alertDescription.getSeverity());
        assertEquals("http://timeo.nextworks.it/timeo/alerts", alertDescription.getTarget());
        assertEquals(42.0, alertDescription.getValue(), 0.000001);
    }
}