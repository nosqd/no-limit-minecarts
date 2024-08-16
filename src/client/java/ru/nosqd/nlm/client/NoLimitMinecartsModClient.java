/**
 * Client-side initialization class for No Limit Minecarts mod.
 */
package ru.nosqd.nlm.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoLimitMinecartsModClient implements ClientModInitializer {
    /**
     * Logger instance for the client-side mod.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger("no-limit-minecarts-client");

    /**
     * Initializes the client-side components of the mod.
     * This method is called by the Fabric loader when the game starts on the client side.
     */
    @Override
    public void onInitializeClient() {
        // Currently empty, but can be used for future client-side initialization if needed.
    }
}