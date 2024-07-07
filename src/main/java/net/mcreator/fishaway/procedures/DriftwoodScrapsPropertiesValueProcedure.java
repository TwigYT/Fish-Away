package net.mcreator.fishaway.procedures;

import net.mcreator.fishaway.configuration.ItemsConfigConfiguration;

public class DriftwoodScrapsPropertiesValueProcedure {
	public static double execute() {
		return (double) ItemsConfigConfiguration.DRIFTWOOD_SCRAPS_BURN_TIME.get();
	}
}
