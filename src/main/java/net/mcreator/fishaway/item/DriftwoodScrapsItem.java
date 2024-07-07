
package net.mcreator.fishaway.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DriftwoodScrapsItem extends Item {
	public DriftwoodScrapsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
