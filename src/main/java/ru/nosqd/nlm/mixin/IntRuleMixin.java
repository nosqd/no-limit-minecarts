/**
 * Mixin class for modifying the IntRule game rule to allow for higher maximum values.
 * This is used to increase the maximum speed limit for minecarts.
 */
package ru.nosqd.nlm.mixin;

import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BiConsumer;

/**
 * Mixin for IntRule to change maximum of maxMinecartSpeed gamerule
 */
@Mixin(GameRules.IntRule.class)
public abstract class IntRuleMixin {
    @Shadow
    static GameRules.Type<GameRules.IntRule> create(int initialValue, int min, int max, FeatureSet featureSet, BiConsumer<MinecraftServer, GameRules.IntRule> biConsumer) {
        return null;
    }

    /**
     * Modifies the creation of IntRule to allow for a higher maximum value when the MINECART_IMPROVEMENTS feature is enabled.
     *
     * @param initialValue The initial value of the rule.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @param featureSet The set of enabled features.
     * @param biConsumer A BiConsumer for additional processing.
     * @param cir Callback info returnable containing the created IntRule.
     */
    @Inject(method = "create(IIILnet/minecraft/resource/featuretoggle/FeatureSet;Ljava/util/function/BiConsumer;)Lnet/minecraft/world/GameRules$Type;", at = @At("RETURN"), cancellable = true)
    private static void create(int initialValue, int min, int max, FeatureSet featureSet, BiConsumer<MinecraftServer, GameRules.IntRule> biConsumer, CallbackInfoReturnable<GameRules.Type<GameRules.IntRule>> cir) {
        // TODO: find better solution to this.
        if (featureSet.contains(FeatureFlags.MINECART_IMPROVEMENTS) && max == 1000) {
            cir.setReturnValue(create(initialValue, min, 2147483647, featureSet, biConsumer));
            return;
        }
    }
}