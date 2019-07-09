package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * Created by Marco Capitani on 29/01/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class VnfGetIndicatorTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(VnfGetIndicatorTask.class);

    private GeneralizedQueryRequest request;
    private VnfRestClient client;
    private String vnfInstanceId;
    private Consumer<VnfGetIndicatorTask> listener;
    UUID id = UUID.randomUUID();
    GetIndicatorValueResponse result;

    VnfGetIndicatorTask(
            GeneralizedQueryRequest request,
            VnfRestClient client,
            String vnfInstanceId,
            Consumer<VnfGetIndicatorTask> listener
    ) {
        if (null == request) {
            throw new IllegalArgumentException("Null request provided");
        }
        if (null == client) {
            throw new NullPointerException("client must not be null.");
        }
        if (null == vnfInstanceId) {
            throw new NullPointerException("vnfInstanceId must not be null.");
        }
        this.request = request;
        this.client = client;
        this.vnfInstanceId = vnfInstanceId;
        this.listener = listener;
    }

    @Override
    public void run() {
        log.debug("Running VNF config task");
        try {
            GetIndicatorValueResponse indicatorValue = client.getIndicatorValue(request);
            log.debug("Received Vnf Indicator values from vnf instance: '{}'.", vnfInstanceId);
            log.debug("Response: '{}'.", indicatorValue);
            result = indicatorValue;
            listener.accept(this);
        } catch (FailedOperationException e) {
            log.error("Get VNF indicator failed. {}: {}.", e.getClass().getSimpleName(), e.getMessage());
            log.debug("Details: ", e);
        }
    }
}
