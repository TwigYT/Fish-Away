
package net.mcreator.fishaway.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;

public class CopperFishingRodItem extends FishingRodItem {
	public CopperFishingRodItem() {
		super(new Item.Properties().durability(90));
	}

	@Override
	public int getEnchantmentValue() {
		return 10;
	}
}
