/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minewatch.init;

import net.minecraft.world.item.CreativeModeTabs;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class MinewatchModTabs {
	public static void load() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(tabData -> {
			tabData.accept(MinewatchModItems.MINE_WATCH);
		});
	}
}