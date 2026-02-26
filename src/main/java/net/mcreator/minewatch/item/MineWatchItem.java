package net.mcreator.minewatch.item;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.minewatch.procedures.ShowTimeProcedure;
import net.mcreator.minewatch.procedures.ChangeStatusProcedure;

public class MineWatchItem extends Item {
	public MineWatchItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		ChangeStatusProcedure.execute(entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ChangeStatusProcedure.execute(context.getPlayer());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		ShowTimeProcedure.execute(entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}