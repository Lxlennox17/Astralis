package net.lxlennox.astralis.world;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.world.tree.custom.MoonveilTreeFoliagePlacer;
import net.lxlennox.astralis.world.tree.custom.MoonveilTreeTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;



public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOONVEIL_TREE_KEY = registerKey("moonveil_tree");








        public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, MOONVEIL_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MOONVEIL_LOG),
                new MoonveilTreeTrunkPlacer(7, 3, 2),
                BlockStateProvider.of(ModBlocks.MOONVEIL_LEAVES),
                new MoonveilTreeFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(ModBlocks.MOONVEIL_LOG)).build());








    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Astralis.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
