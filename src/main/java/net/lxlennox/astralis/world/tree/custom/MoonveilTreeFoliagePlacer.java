package net.lxlennox.astralis.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lxlennox.astralis.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class MoonveilTreeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<MoonveilTreeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((
            nameTreeFoliagePlacerInstance) ->
            fillFoliagePlacerFields(nameTreeFoliagePlacerInstance).and(Codec.intRange(0, 12)
                            .fieldOf("height").forGetter(NameTreeFoliagePlacerInstance ->
                                    NameTreeFoliagePlacerInstance.height))
                    .apply(nameTreeFoliagePlacerInstance, MoonveilTreeFoliagePlacer::new));
    private final int height;
    public MoonveilTreeFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.MOONVEIL_FOLIAGE_PLACER;
    }
    protected void generatePattern(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos centerPos, int minRadius, int maxRadius, int bigLayers, int height, boolean giantTrunk) {
        // if you want to make foliage height bigger, then just make height bigger
        for (int i = 0; i <= height;i = i+2) {
            //when tree is a ~ half, there should be spawn circles with maxRadius radius. If you want to make more layers with maxRadius you should make bigger bigLayers.
            if(i >= height/2-bigLayers/2 && i <=height/2 + bigLayers/2) {
                generateCircle(world, placer, random, config, centerPos.down(i), maxRadius, 0, giantTrunk);
                generateCircle(world, placer, random, config, centerPos.down(i+1), maxRadius-1, 0, giantTrunk);
            }
            else{
                generateCircle(world, placer, random, config, centerPos.down(i), minRadius, 0, giantTrunk);
                generateCircle(world, placer, random, config, centerPos.down(i+1), minRadius-1, 0, giantTrunk);

            }
        }
    }
    protected void generateCircle(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos centerPos, int radius, int y, boolean giantTrunk) {
        generateSquare(world, placer, random, config, centerPos, radius, y, giantTrunk);
        int r = radius;
        if(r <= 0) {r = 1;}
        for (int i = 0; i < 2*radius-radius; i++) {
            placeFoliageBlock(world, placer, random, config, centerPos.west(r+1).north(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.west(r+1).south(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.north(r+1).west(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.north(r+1).east(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.east(r+1).north(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.east(r+1).south(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.south(r+1).west(i).up(y));
            placeFoliageBlock(world, placer, random, config, centerPos.south(r+1).east(i).up(y));
        }
    }
    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up(2));
        placeFoliageBlock(world, placer, random, config, treeNode.getCenter().up(1));
        generateCircle(world, placer, random, config, treeNode.getCenter(),
                1, 0, treeNode.isGiantTrunk());
        generateCircle(world, placer, random, config, treeNode.getCenter().down(1),
                1, 0, treeNode.isGiantTrunk());
        generatePattern(world, placer, random, config, treeNode.getCenter().down(2),
                2, 3, 2, 6, treeNode.isGiantTrunk());

    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
