package net.mcreator.minewatch.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minewatch.network.MinewatchModVariables;

public class ShowTimeProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide() && world != null) {
			long time = Math.abs(_player.level().getDayTime());
			int daytime = (int) (time % 24000);
			int mins = (int) (Math.round(daytime / 16.6));
			long day = time / 24000 + 1;
			int hour = mins / 60 + 6;
			int min = mins % 60;
			if (hour >= 24) {
				hour -= 24;
			}
			MinewatchModVariables.MapVariables.get(world).NowTimeText = String.format("Day %d %02d:%02d", day, hour, min);
			MinewatchModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (entity instanceof Player _player && !_player.level().isClientSide()) {
			_player.displayClientMessage(Component.literal(MinewatchModVariables.MapVariables.get(world).NowTimeText), true);
		}
	}
}