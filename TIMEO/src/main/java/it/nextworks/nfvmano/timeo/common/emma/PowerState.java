package it.nextworks.nfvmano.timeo.common.emma;

public enum PowerState {

	POWER_OFF,
	SLEEPING,
	LOW_POWER,
	MEDIUM_POWER,
	HIGH_POWER,
	POWER_ON;

	public static PowerState withName(String name) {
		if (null == name) {
			return null;
		}
		name = name.replace('-', '_');
		name = name.replaceAll("([a-z])([A-Z])", "$1_$2");
		name = name.toUpperCase();
		if (name.equals("READY")) return SLEEPING;
		return PowerState.valueOf(name);
	}
	
}
