package net.lxlennox.astralis.worldgen.feature;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.worldgen.feature.custom.HugeForestStoneFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;


import java.util.function.Supplier;

public class ModFeatures <FC extends FeatureConfig> {

   public static Feature<SingleStateFeatureConfig> HUGE_FOREST_STONE;

    public static void registerFeatures() {
        Astralis.LOGGER.info("|\t-Registering Features");
        HUGE_FOREST_STONE = registerCustomFeature("huge_purple_mushroom", new HugeForestStoneFeature(SingleStateFeatureConfig.CODEC));

    }

    private static <C extends FeatureConfig, F extends Feature<C>> F registerCustomFeature(String name, F feature) {
        return Registry.register(Registries.FEATURE, Identifier.of(Astralis.MOD_ID, name), feature);
    }
}


