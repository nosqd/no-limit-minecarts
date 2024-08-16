package ru.nosqd.nlm.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import ru.nosqd.nlm.NoLimitMinecartsMod;

public class NoLimitMinecartsApi {
    private static NoLimitMinecartsApi instance;

    public static void initialize() {
        if (instance != null) {
            NoLimitMinecartsMod.LOGGER.warn("Some function tried to reinitialize nlm api, nothing will be done");
            return;
        }
        instance = new NoLimitMinecartsApi();
    }

    public static NoLimitMinecartsApi getInstance() {
        return instance;
    }

    public boolean isPlayerRiding(PlayerEntity player) {
        return player.hasVehicle();
    }

    public Entity getPlayerVehicle(PlayerEntity player) {
        return player.getVehicle();
    }

    public double getVehicleSpeed(Entity entity) {
        var velocity = entity.getVelocity();

        double speedInBlocksPerTick = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y + velocity.z * velocity.z);
        return speedInBlocksPerTick * 20;
    }
}
