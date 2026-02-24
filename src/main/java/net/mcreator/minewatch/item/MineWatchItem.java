package net.mcreator.minewatch.item;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.minewatch.procedures.ShowTimeProcedure;

public class MineWatchItem extends Item {
	public MineWatchItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		ShowTimeProcedure.execute(world, entity);
	}
}