
package net.mcreator.fishaway.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;

public class DiamondFishingRodItem extends FishingRodItem {
	public DiamondFishingRodItem() {
		super(new Item.Properties().durability(384));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.DIAMOND)).test(repairitem);
	}

	@Override
	public int getEnchantmentValue() {
		return 10;
	}
}
