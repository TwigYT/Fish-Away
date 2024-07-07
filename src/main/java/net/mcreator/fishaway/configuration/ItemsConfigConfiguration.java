package net.mcreator.fishaway.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ItemsConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> DRIFTWOOD_SCRAPS_BURN_TIME;
	static {
		BUILDER.push("burn times");
		DRIFTWOOD_SCRAPS_BURN_TIME = BUILDER.comment("the burn time of driftwood scraps (in ticks)").define("driftwood_scraps", (double) 100);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
