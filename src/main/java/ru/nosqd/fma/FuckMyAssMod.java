package ru.nosqd.fma;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;

import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FuckMyAssMod implements DedicatedServerModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("fmamod");

	@Override
	public void onInitializeServer() {
		LOGGER.info("pososi");

	}
}