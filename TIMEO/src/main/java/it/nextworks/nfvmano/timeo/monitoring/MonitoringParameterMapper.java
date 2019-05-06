package it.nextworks.nfvmano.timeo.monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreatePmJobRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;

/**
 * Utility class to translate a monitoring parameter, as expressed into the NSD, into 
 * monitoring parameters to be requested to the MANO monitoring system.
 * 
 * @author nextworks
 *
 */
public class MonitoringParameterMapper {
	
	private static final Logger log = LoggerFactory.getLogger(MonitoringParameterMapper.class);

	public MonitoringParameterMapper() {
		// TODO Auto-generated constructor stub
	}

	public static CreatePmJobRequest translateMonitoringParameter(String performanceMetric, NsInfo nsInfo) 
			throws MalformattedElementException, NotExistingEntityException {
		log.debug("Processing metric " + performanceMetric);
		String [] splits = performanceMetric.split("\\.");
		//This should be updated
		if (splits.length != 2) throw new MalformattedElementException("Wrong metric format. Performance metric in monitoring parameter should be in format <metricType>.<vnfdId>");
		String metricType = splits[0];
		String vnfdId = splits[1];
		//TODO:
		return null;
	}
	
}
