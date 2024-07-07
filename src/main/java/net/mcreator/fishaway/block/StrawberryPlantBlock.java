
package net.mcreator.fishaway.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.fishaway.procedures.StrawberryPlantUpdateTickProcedure;
import net.mcreator.fishaway.procedures.StrawberryPlantOnBoneMealSuccessProcedure;
import net.mcreator.fishaway.procedures.StrawberryPlantBlockDestroyedByPlayerProcedure;
import net.mcreator.fishaway.init.FishAwayModItems;

public class StrawberryPlantBlock extends Block implements BonemealableBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);

	public StrawberryPlantBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRASS).instabreak().lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				return 0;
			}
		}.getLightLevel())).noCollission().noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false).dynamicShape().offsetType(Block.OffsetType.XZ));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			Vec3 offset = state.getOffset(world, pos);
			return box(2, 2, 2, 14, 4, 14).move(offset.x, offset.y, offset.z);
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			Vec3 offset = state.getOffset(world, pos);
			return box(2, 2, 2, 14, 8, 14).move(offset.x, offset.y, offset.z);
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			Vec3 offset = state.getOffset(world, pos);
			return box(2, 2, 2, 14, 8, 14).move(offset.x, offset.y, offset.z);
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			Vec3 offset = state.getOffset(world, pos);
			return box(2, 2, 2, 14, 8, 14).move(offset.x, offset.y, offset.z);
		}
		Vec3 offset = state.getOffset(world, pos);
		return box(2, 2, 2, 14, 4, 14).move(offset.x, offset.y, offset.z);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BLOCKSTATE);
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return new ItemStack(FishAwayModItems.STRAWBERRY.get());
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		StrawberryPlantUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		StrawberryPlantBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		return retval;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		StrawberryPlantOnBoneMealSuccessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}
