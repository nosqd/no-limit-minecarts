/**
 * Main mod class for No Limit Minecarts.
 * This mod allows changing the maximum speed of minecarts and adds a speedometer.
 */
package ru.nosqd.nlm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.nosqd.nlm.api.NoLimitMinecartsApi;

public class NoLimitMinecartsMod implements ModInitializer {
	/**
	 * Logger instance for the mod.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger("no-limit-minecarts");

	/**
	 * Version of the mod, loaded from the mod metadata.
	 */
	public static final String VERSION;

	static {
		ModContainer mod = FabricLoader.getInstance().getModContainer("no-limit-minecarts").orElseThrow();
		VERSION = mod.getMetadata().getVersion().getFriendlyString();
	}

	/**
	 * Initializes the mod.
	 * This method is called by the Fabric loader when the game starts.
	 */
	@Override
	public void onInitialize() {
		LOGGER.info("Starting No Limit Minecarts mod");
		NoLimitMinecartsApi.initialize();
	}
}