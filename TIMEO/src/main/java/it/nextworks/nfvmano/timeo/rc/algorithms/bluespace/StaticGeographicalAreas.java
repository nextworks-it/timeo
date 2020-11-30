package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.LocationInfo;

public class StaticGeographicalAreas {

	static public String getDefaultAreaId(){
		return "1";
	}

	/**
	 * @return the geographicalAreas key: areaId; value: geographical coordinates
	 */
	static public Map<String, LocationInfo> getGeographicalAreas() {
		Map<String, LocationInfo> geographicalAreas = new HashMap<>();
		geographicalAreas.put("1", new LocationInfo(10D, 10D, 0, 10));
		geographicalAreas.put("2", new LocationInfo(20D, 20D, 0, 10));
		geographicalAreas.put("3", new LocationInfo(30D, 30D, 0, 1000));
		geographicalAreas.put("4", new LocationInfo(40D, 40D, 0, 1000));
		geographicalAreas.put("5", new LocationInfo(50D, 50D, 0, 1000));
		geographicalAreas.put("6", new LocationInfo(60D, 60D, 0, 1000));
		return geographicalAreas;
	}
}
