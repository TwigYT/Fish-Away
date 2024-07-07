
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fishaway.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.fishaway.item.StrawberryItem;
import net.mcreator.fishaway.item.PearItem;
import net.mcreator.fishaway.item.NetheriteFishingRodItem;
import net.mcreator.fishaway.item.IronFishingRodItem;
import net.mcreator.fishaway.item.GoldenFishingRodItem;
import net.mcreator.fishaway.item.DriftwoodScrapsItem;
import net.mcreator.fishaway.item.DiamondFishingRodItem;
import net.mcreator.fishaway.item.CopperSwordItem;
import net.mcreator.fishaway.item.CopperShovelItem;
import net.mcreator.fishaway.item.CopperPickaxeItem;
import net.mcreator.fishaway.item.CopperHoeItem;
import net.mcreator.fishaway.item.CopperFishingRodItem;
import net.mcreator.fishaway.item.CopperAxeItem;
import net.mcreator.fishaway.FishAwayMod;

public class FishAwayModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, FishAwayMod.MODID);
	public static final DeferredHolder<Item, Item> PEAR = REGISTRY.register("pear", () -> new PearItem());
	public static final DeferredHolder<Item, Item> COPPER_AXE = REGISTRY.register("copper_axe", () -> new CopperAxeItem());
	public static final DeferredHolder<Item, Item> DRIFTWOOD_SCRAPS = REGISTRY.register("driftwood_scraps", () -> new DriftwoodScrapsItem());
	public static final DeferredHolder<Item, Item> COPPER_FISHING_ROD = REGISTRY.register("copper_fishing_rod", () -> new CopperFishingRodItem());
	public static final DeferredHolder<Item, Item> IRON_FISHING_ROD = REGISTRY.register("iron_fishing_rod", () -> new IronFishingRodItem());
	public static final DeferredHolder<Item, Item> GOLDEN_FISHING_ROD = REGISTRY.register("golden_fishing_rod", () -> new GoldenFishingRodItem());
	public static final DeferredHolder<Item, Item> DIAMOND_FISHING_ROD = REGISTRY.register("diamond_fishing_rod", () -> new DiamondFishingRodItem());
	public static final DeferredHolder<Item, Item> NETHERITE_FISHING_ROD = REGISTRY.register("netherite_fishing_rod", () -> new NetheriteFishingRodItem());
	public static final DeferredHolder<Item, Item> COPPER_PICKAXE = REGISTRY.register("copper_pickaxe", () -> new CopperPickaxeItem());
	public static final DeferredHolder<Item, Item> COPPER_SHOVEL = REGISTRY.register("copper_shovel", () -> new CopperShovelItem());
	public static final DeferredHolder<Item, Item> COPPER_HOE = REGISTRY.register("copper_hoe", () -> new CopperHoeItem());
	public static final DeferredHolder<Item, Item> COPPER_SWORD = REGISTRY.register("copper_sword", () -> new CopperSwordItem());
	public static final DeferredHolder<Item, Item> DIAMOND_CHUNK_STONE = block(FishAwayModBlocks.DIAMOND_CHUNK_STONE);
	public static final DeferredHolder<Item, Item> DIAMOND_CHUNK_DEEPSLATE = block(FishAwayModBlocks.DIAMOND_CHUNK_DEEPSLATE);
	public static final DeferredHolder<Item, Item> EMERALD_CHUNK_STONE = block(FishAwayModBlocks.EMERALD_CHUNK_STONE);
	public static final DeferredHolder<Item, Item> EMERALD_CHUNK_DEEPSLATE = block(FishAwayModBlocks.EMERALD_CHUNK_DEEPSLATE);
	public static final DeferredHolder<Item, Item> STRAWBERRY = REGISTRY.register("strawberry", () -> new StrawberryItem());
	public static final DeferredHolder<Item, Item> STRAWBERRY_PLANT = block(FishAwayModBlocks.STRAWBERRY_PLANT);

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
