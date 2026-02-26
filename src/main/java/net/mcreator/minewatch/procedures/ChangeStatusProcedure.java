package net.mcreator.minewatch.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minewatch.network.MinewatchModVariables;

public class ChangeStatusProcedure {
	public static boolean eventResult = true;

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES).ShowType).equals("hide")) {
			{
				MinewatchModVariables.PlayerVariables _vars = entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES);
				_vars.ShowType = "time";
				_vars.markSyncDirty();
			}
		} else if ((entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES).ShowType).equals("time")) {
			{
				MinewatchModVariables.PlayerVariables _vars = entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES);
				_vars.ShowType = "xyz";
				_vars.markSyncDirty();
			}
		} else {
			{
				MinewatchModVariables.PlayerVariables _vars = entity.getAttachedOrCreate(MinewatchModVariables.PLAYER_VARIABLES);
				_vars.ShowType = "hide";
				_vars.markSyncDirty();
			}
		}
	}
}