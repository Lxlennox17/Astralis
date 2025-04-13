package net.lxlennox.astralis.worldgen.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.lxlennox.astralis.worldgen.ModPlacedFeatures;
import net.lxlennox.astralis.worldgen.biome.ModBiomes;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MOONVEIL_WOODS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOONVEIL_TREE_PLACED_KEY);
    }
}