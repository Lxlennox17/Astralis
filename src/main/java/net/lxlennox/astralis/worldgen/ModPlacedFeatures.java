package net.lxlennox.astralis.worldgen;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MOONVEIL_TREE_PLACED_KEY = registerKey("moonveil_placed");
    public static final RegistryKey<PlacedFeature> STELLAR_GRASS_PLACED_KEY = registerKey("stellar_grass_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, MOONVEIL_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOONVEIL_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(10, 0.1f, 2), ModBlocks.MOONVEIL_SAPLING));

        register(context,STELLAR_GRASS_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.STELLAR_GRASS_KEY),
                CountPlacementModifier.of(10), SquarePlacementModifier.of(),PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());



    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE,Astralis.id(name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
