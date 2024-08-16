/**
 * API class for No Limit Minecarts mod.
 * Provides utility methods for interacting with players and vehicles.
 */
package ru.nosqd.nlm.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import ru.nosqd.nlm.NoLimitMinecartsMod;

/**
 * Api for using in other mods.
 */
public class NoLimitMinecartsApi {
    private static NoLimitMinecartsApi instance;

    /**
     * Initializes the API instance.
     * This method should be called only once during mod initialization.
     */
    public static void initialize() {
        if (instance != null) {
            NoLimitMinecartsMod.LOGGER.warn("Some function tried to reinitialize nlm api, nothing will be done");
            return;
        }
        instance = new NoLimitMinecartsApi();
    }

    /**
     * Gets the singleton instance of the API.
     * @return The NoLimitMinecartsApi instance.
     */
    public static NoLimitMinecartsApi getInstance() {
        return instance;
    }

    /**
     * Checks if a player is riding a vehicle.
     * @param player The player to check.
     * @return true if the player is riding a vehicle, false otherwise.
     */
    public boolean isPlayerRiding(PlayerEntity player) {
        return player.hasVehicle();
    }

    /**
     * Gets the vehicle a player is riding.
     * @param player The player to check.
     * @return The Entity representing the vehicle, or null if the player is not riding.
     */
    public Entity getPlayerVehicle(PlayerEntity player) {
        return player.getVehicle();
    }

    /**
     * Calculates the speed of a vehicle entity in blocks per second.
     * @param entity The entity (vehicle) to check.
     * @return The speed of the entity in blocks per second.
     */
    public double getVehicleSpeed(Entity entity) {
        var velocity = entity.getVelocity();

        double speedInBlocksPerTick = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y + velocity.z * velocity.z);
        return speedInBlocksPerTick * 20;
    }
}