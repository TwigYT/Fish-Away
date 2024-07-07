
package net.mcreator.fishaway.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.entity.Entity;

import net.mcreator.fishaway.procedures.GoldenFishingRodToolInHandTickProcedure;

public class GoldenFishingRodItem extends FishingRodItem {
	public GoldenFishingRodItem() {
		super(new Item.Properties().durability(50));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.GOLD_INGOT)).test(repairitem);
	}

	@Override
	public int getEnchantmentValue() {
		return 2;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			GoldenFishingRodToolInHandTickProcedure.execute(entity);
	}
}
