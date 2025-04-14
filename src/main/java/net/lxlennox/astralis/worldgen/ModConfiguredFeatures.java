package net.lxlennox.astralis.worldgen;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.worldgen.tree.custom.MoonveilTreeFoliagePlacer;
import net.lxlennox.astralis.worldgen.tree.custom.MoonveilTreeTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOONVEIL_TREE_KEY = registerKey("moonveil_tree");
public static final RegistryKey<ConfiguredFeature<?, ?>> STELLAR_GRASS_KEY = registerKey("stellar_grass");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, MOONVEIL_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MOONVEIL_LOG),
                new MoonveilTreeTrunkPlacer(7, 3, 2),
                BlockStateProvider.of(ModBlocks.MOONVEIL_LEAVES),
                new MoonveilTreeFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(ModBlocks.MOONVEIL_LOG)).build()
        );

        WeightedBlockStateProvider weightedGrassProvider = new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(ModBlocks.STELLAR_SPROUTS.getDefaultState(), 1)
                        .add(ModBlocks.STELLAR_GRASS.getDefaultState(), 4)
        );

        register(context, STELLAR_GRASS_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(weightedGrassProvider, 32)
        );



    }
    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider provider, int tries) {
        return new RandomPatchFeatureConfig(
                tries, 6, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(provider))
        );
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,Astralis.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
