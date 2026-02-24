/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minewatch.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.minewatch.item.MineWatchItem;
import net.mcreator.minewatch.MinewatchMod;

import java.util.function.Function;

public class MinewatchModItems {
	public static Item MINE_WATCH;

	public static void load() {
		MINE_WATCH = register("mine_watch", MineWatchItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MinewatchMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}
}