
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fishaway.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.fishaway.block.StrawberryPlantBlock;
import net.mcreator.fishaway.block.EmeraldChunkStoneBlock;
import net.mcreator.fishaway.block.EmeraldChunkDeepslateBlock;
import net.mcreator.fishaway.block.DiamondChunkStoneBlock;
import net.mcreator.fishaway.block.DiamondChunkDeepslateBlock;
import net.mcreator.fishaway.FishAwayMod;

public class FishAwayModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, FishAwayMod.MODID);
	public static final DeferredHolder<Block, Block> DIAMOND_CHUNK_STONE = REGISTRY.register("diamond_chunk_stone", () -> new DiamondChunkStoneBlock());
	public static final DeferredHolder<Block, Block> DIAMOND_CHUNK_DEEPSLATE = REGISTRY.register("diamond_chunk_deepslate", () -> new DiamondChunkDeepslateBlock());
	public static final DeferredHolder<Block, Block> EMERALD_CHUNK_STONE = REGISTRY.register("emerald_chunk_stone", () -> new EmeraldChunkStoneBlock());
	public static final DeferredHolder<Block, Block> EMERALD_CHUNK_DEEPSLATE = REGISTRY.register("emerald_chunk_deepslate", () -> new EmeraldChunkDeepslateBlock());
	public static final DeferredHolder<Block, Block> STRAWBERRY_PLANT = REGISTRY.register("strawberry_plant", () -> new StrawberryPlantBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
