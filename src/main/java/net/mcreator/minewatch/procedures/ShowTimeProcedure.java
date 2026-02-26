package net.mcreator.minewatch.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.minewatch.network.MinewatchModVariables;

public class ShowTimeProcedure {
	public static boolean eventResult = true;

	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES).ShowType).equals("time")) {
			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				long time = Math.abs(_player.level().getDayTime());
				int daytime = (int) (time % 24000);
				int mins = (int) (Math.round(daytime / 16.6));
				long day = time / 24000 + 1;
				int hour = mins / 60 + 6;
				int min = mins % 60;
				if (hour >= 24) {
					hour -= 24;
				}
				MinewatchModVariables.PlayerVariables _vars = entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES);
				_vars.NowTimeText = String.format("Day %d %02d:%02d", day, hour, min);
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				_player.displayClientMessage(Component.literal(entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES).NowTimeText), true);
			}
		} else if ((entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES).ShowType).equals("xyz")) {
			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				_player.displayClientMessage(Component.literal(("X=" + Math.floor(x) + " Y=" + Math.floor(y) + " Z=" + Math.floor(z))), true);
			}
		}
	}
}