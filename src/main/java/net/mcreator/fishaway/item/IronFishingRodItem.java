
package net.mcreator.fishaway.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;

public class IronFishingRodItem extends FishingRodItem {
	public IronFishingRodItem() {
		super(new Item.Properties().durability(128));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.IRON_INGOT)).test(repairitem);
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}
}
