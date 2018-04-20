package it.nextworks.nfvmano.timeo.common;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

	@Bean(name=NfvoConstants.engineQueueExchange)
	TopicExchange exchange() {
		return new TopicExchange(NfvoConstants.engineQueueExchange, true, false);
	}
	
	@Bean(name=NfvoConstants.computationQueueExchange)
	TopicExchange computationExchange() {
		return new TopicExchange(NfvoConstants.computationQueueExchange, true, false);
	}
	
	@Bean(name=NfvoConstants.allocationQueueExchange)
	TopicExchange allocationExchange() {
		return new TopicExchange(NfvoConstants.allocationQueueExchange, true, false);
	}
	
	@Bean(name=NfvoConstants.vnfmQueueExchange)
	TopicExchange vnfmExchange() {
		return new TopicExchange(NfvoConstants.vnfmQueueExchange, true, false);
	}

}
