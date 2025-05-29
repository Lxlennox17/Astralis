package net.lxlennox.astralis.worldgen;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.tag.ModTags;
import net.lxlennox.astralis.worldgen.tree.custom.MoonveilTreeFoliagePlacer;
import net.lxlennox.astralis.worldgen.tree.custom.MoonveilTreeTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOONVEIL_TREE_KEY = registerKey("moonveil_tree");
public static final RegistryKey<ConfiguredFeature<?, ?>> STELLAR_GRASS_KEY = registerKey("stellar_grass");
public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SNOWBLOOM_KEY = registerKey("patch_snowbloom");
public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_FROSTBLOOM_PETALS_KEY = registerKey("patch_frostbloom_petals");
public static final RegistryKey<ConfiguredFeature<?, ?>> LUNARIUM_ORE_KEY = registerKey("lunarium_ore");
public static final RegistryKey<ConfiguredFeature<?, ?>> MOSSY_STELLAR_STONE_KEY = registerKey("mossy_stellar_stone");



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

        register(context, PATCH_SNOWBLOOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of(ModBlocks.SNOWBLOOM)))
        );

        DataPool.Builder<BlockState> builder = DataPool.builder();

        for (int i = 1; i <= 4; i++) {
            for (Direction direction : Direction.Type.HORIZONTAL) {
                builder.add(ModBlocks.FROSTBLOOM_PETALS.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, i).with(FlowerbedBlock.FACING, direction), 1);
            }
        }
        ConfiguredFeatures.register(
                context,
                PATCH_FROSTBLOOM_PETALS_KEY,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))
                )
        );

        RuleTest stellarStoneReplaceables= new TagMatchRuleTest(ModTags.STELLAR_STONE_ORE_REPLACEABLES);
        RuleTest stellarslateReplaceables=new TagMatchRuleTest(ModTags.STELLARSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldEclipseOres=
                List.of(OreFeatureConfig.createTarget(stellarStoneReplaceables,ModBlocks.LUNARIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(stellarslateReplaceables,ModBlocks.STELLARSLATE_LUNARIUM_ORE.getDefaultState()));

        register(context,LUNARIUM_ORE_KEY,Feature.ORE,new OreFeatureConfig(overworldEclipseOres,8)
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
