/**
 * Mixin class for adding No Limit Minecarts information to the debug HUD.
 */
package ru.nosqd.nlm.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.DebugHud;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.nosqd.nlm.NoLimitMinecartsMod;
import ru.nosqd.nlm.api.NoLimitMinecartsApi;

import java.util.List;

@Mixin(DebugHud.class)
public class DebugHudMixin {
    /**
     * Injects additional information into the debug HUD's left text.
     * Adds No Limit Minecarts mod version and vehicle speed (if applicable).
     *
     * @param cir Callback info returnable containing the list of debug text lines.
     */
    @Inject(method = "getLeftText", at = @At("RETURN"), cancellable = true)
    private void getLeftText(CallbackInfoReturnable<List<String>> cir) {
        var lines = cir.getReturnValue();
        var nlmApi = NoLimitMinecartsApi.getInstance();
        var player = MinecraftClient.getInstance().player;

        lines.add("");

        lines.add(Formatting.GREEN + "[No Limit Minecarts]");
        lines.add(Formatting.AQUA + "Version: " + Formatting.GOLD + NoLimitMinecartsMod.VERSION);
        if (player != null) {
            if (nlmApi.isPlayerRiding(player)) {
                var vehicle = nlmApi.getPlayerVehicle(player);
                lines.add(Formatting.YELLOW + "Speed: " + Formatting.LIGHT_PURPLE + String.format("%.3f", nlmApi.getVehicleSpeed(vehicle)));
            }
            else {
                lines.add(Formatting.YELLOW + "Player is not riding a vehicle.");
            }
        }
        else {
            lines.add(Formatting.RED + "Player is null.");
        }

        cir.setReturnValue(lines);
    }
}