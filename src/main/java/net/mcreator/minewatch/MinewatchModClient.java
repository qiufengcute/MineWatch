package net.mcreator.minewatch;

import net.mcreator.minewatch.network.MinewatchModVariables;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

@Environment(EnvType.CLIENT)
public class MinewatchModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		ClientPlayNetworking.registerGlobalReceiver(MinewatchModVariables.PlayerVariablesSyncMessage.TYPE, MinewatchModVariables.PlayerVariablesSyncMessage::handleData);
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}