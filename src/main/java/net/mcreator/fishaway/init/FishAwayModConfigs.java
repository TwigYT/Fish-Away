package net.mcreator.fishaway.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.fishaway.configuration.ItemsConfigConfiguration;
import net.mcreator.fishaway.FishAwayMod;

@Mod.EventBusSubscriber(modid = FishAwayMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishAwayModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ItemsConfigConfiguration.SPEC, "items_config.toml");
		});
	}
}
