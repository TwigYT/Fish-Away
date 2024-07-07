package net.mcreator.fishaway.init;

import org.checkerframework.checker.units.qual.m;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.fishaway.FishAwayMod;

import java.util.function.Supplier;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.Codec;

import com.google.common.base.Suppliers;

@Mod.EventBusSubscriber(modid = FishAwayMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishAwayModLootModifier {
	public static class FishAwayModLootTableModifier extends LootModifier {
		public static final Supplier<Codec<FishAwayModLootTableModifier>> CODEC = Suppliers
				.memoize(() -> RecordCodecBuilder.create(instance -> codecStart(instance).and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter(m -> m.lootTable)).apply(instance, FishAwayModLootTableModifier::new)));
		private final ResourceLocation lootTable;

		public FishAwayModLootTableModifier(LootItemCondition[] conditions, ResourceLocation lootTable) {
			super(conditions);
			this.lootTable = lootTable;
		}

		@Override
		protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
			context.getResolver().getLootTable(lootTable).getRandomItemsRaw(context, generatedLoot::add);
			return generatedLoot;
		}

		@Override
		public Codec<? extends IGlobalLootModifier> codec() {
			return CODEC.get();
		}
	}

	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "fish_away");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			LOOT_MODIFIER.register("fish_away_loot_modifier", FishAwayModLootTableModifier.CODEC);
			LOOT_MODIFIER.register(bus);
		});
	}
}
