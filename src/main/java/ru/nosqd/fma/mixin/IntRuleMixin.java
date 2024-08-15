package ru.nosqd.fma.mixin;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BiConsumer;

@Mixin(GameRules.IntRule.class)
public abstract class IntRuleMixin {
    @Shadow
    static GameRules.Type<GameRules.IntRule> create(int initialValue, int min, int max, FeatureSet featureSet, BiConsumer<MinecraftServer, GameRules.IntRule> biConsumer) {
        return null;
    }

    @Inject(method = "create(IIILnet/minecraft/resource/featuretoggle/FeatureSet;Ljava/util/function/BiConsumer;)Lnet/minecraft/world/GameRules$Type;", at = @At("RETURN"), cancellable = true)
    private static void create(int initialValue, int min, int max, FeatureSet featureSet, BiConsumer<MinecraftServer, GameRules.IntRule> biConsumer, CallbackInfoReturnable<GameRules.Type<GameRules.IntRule>> cir) {
        // this is shit
        if (featureSet.contains(FeatureFlags.field_52556) && max == 1000) {
            cir.setReturnValue(create(initialValue, min, 2147483647, featureSet, biConsumer));
            return;
        }
    }
}
