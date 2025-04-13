package net.lxlennox.astralis.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lxlennox.astralis.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class MoonveilTreeTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<MoonveilTreeTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((
            objectInstance) ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, MoonveilTreeTrunkPlacer::new));
    public MoonveilTreeTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.MOONVEIL_TREE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                 Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int height_ = height + random.nextBetween(firstRandomHeight, secondRandomHeight + 2)
                + random.nextBetween(firstRandomHeight - 2, secondRandomHeight + 1);
        for(int i = 0; i < height_; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height_), 0, false));
    }
}