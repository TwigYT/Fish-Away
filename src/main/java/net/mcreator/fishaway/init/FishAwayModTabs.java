
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fishaway.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.fishaway.FishAwayMod;

public class FishAwayModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FishAwayMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FISH_AWAY = REGISTRY.register("fish_away",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.fish_away.fish_away")).icon(() -> new ItemStack(FishAwayModItems.PEAR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(FishAwayModItems.PEAR.get());
				tabData.accept(FishAwayModItems.STRAWBERRY.get());
				tabData.accept(FishAwayModItems.DRIFTWOOD_SCRAPS.get());
				tabData.accept(FishAwayModItems.COPPER_SWORD.get());
				tabData.accept(FishAwayModItems.COPPER_PICKAXE.get());
				tabData.accept(FishAwayModItems.COPPER_SHOVEL.get());
				tabData.accept(FishAwayModItems.COPPER_AXE.get());
				tabData.accept(FishAwayModItems.COPPER_HOE.get());
				tabData.accept(FishAwayModItems.COPPER_FISHING_ROD.get());
				tabData.accept(FishAwayModItems.IRON_FISHING_ROD.get());
				tabData.accept(FishAwayModItems.GOLDEN_FISHING_ROD.get());
				tabData.accept(FishAwayModItems.DIAMOND_FISHING_ROD.get());
				tabData.accept(FishAwayModItems.NETHERITE_FISHING_ROD.get());
				tabData.accept(FishAwayModBlocks.DIAMOND_CHUNK_STONE.get().asItem());
				tabData.accept(FishAwayModBlocks.DIAMOND_CHUNK_DEEPSLATE.get().asItem());
				tabData.accept(FishAwayModBlocks.EMERALD_CHUNK_STONE.get().asItem());
				tabData.accept(FishAwayModBlocks.EMERALD_CHUNK_DEEPSLATE.get().asItem());
			})

					.build());
}
