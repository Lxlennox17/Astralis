package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MOONVEIL_LOG)
                .add(ModBlocks.MOONVEIL_WOOD)
                .add(ModBlocks.STRIPPED_MOONVEIL_LOG)
                .add(ModBlocks.STRIPPED_MOONVEIL_WOOD);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.MOONVEIL_LEAVES);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MOONVEIL_SAPLING);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.STELLAR_GRASS_BLOCK)
                .add(ModBlocks.STELLAR_DIRT)
                .add(ModBlocks.STELLAR_PODZOL)
                .add(ModBlocks.FROZEN_STELLAR_GRASS);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STELLAR_STONE)
                .add(ModBlocks.STELLAR_COBBLESTONE)
                .add(ModBlocks.STELLARSLATE)
                .add(ModBlocks.COBBLED_STELLARSLATE)
                .add(ModBlocks.DEEPSLATE_LUNARIUM_ORE)
                .add(ModBlocks.LUNARIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_LUNARIUM_ORE)
                .add(ModBlocks.LUNARIUM_ORE);

        getOrCreateTagBuilder(BlockTags.OVERWORLD_CARVER_REPLACEABLES)
                .add(ModBlocks.STELLAR_STONE)
                .add(ModBlocks.STELLARSLATE);



        // Non - Block Blocks
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.MOONVEIL_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MOONVEIL_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.MOONVEIL_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.MOONVEIL_SLAB);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.MOONVEIL_BUTTON);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.MOONVEIL_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.MOONVEIL_DOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.MOONVEIL_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.MOONVEIL_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(ModBlocks.MOONVEIL_WALL_SIGN);

        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.MOONVEIL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.MOONVEIL_WALL_HANGING_SIGN);

    }
}
