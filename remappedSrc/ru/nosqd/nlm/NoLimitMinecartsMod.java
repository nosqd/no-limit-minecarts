package ru.nosqd.nlm;

import net.fabricmc.api.DedicatedServerModInitializer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: maybe add F3 line
// TODO: maybe add when you set value greater than 1000 show message like "Your gamerules are boosted by no limit minecarts"
// TODO: add notification when you join world without minecart feature flag like "this world can't be boosted by no limit minecarts"

public class NoLimitMinecartsMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("no-limit-minecarts");

	@Override
	public void onInitialize() {
		LOGGER.info("Starting No Limit Minecarts mod");
	}
}