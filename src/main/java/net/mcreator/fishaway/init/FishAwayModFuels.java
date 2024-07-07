
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fishaway.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

import net.mcreator.fishaway.procedures.DriftwoodScrapsPropertiesValueProcedure;

@Mod.EventBusSubscriber
public class FishAwayModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == FishAwayModItems.DRIFTWOOD_SCRAPS.get())
			event.setBurnTime((int) DriftwoodScrapsPropertiesValueProcedure.execute());
	}
}
