package net.lxlennox.astralis.worldgen.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.lxlennox.astralis.worldgen.ModPlacedFeatures;
import net.lxlennox.astralis.worldgen.biome.ModBiomes;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration{
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.STELLAR_FIELDS,ModBiomes.MOONVEIL_WOODS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.LUNARIUM_ORE_PLACED_KEY);
    }
}
