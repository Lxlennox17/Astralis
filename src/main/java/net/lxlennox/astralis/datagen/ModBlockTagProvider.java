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
        .add(ModBlocks.STELLAR_GRASS)
        .add(ModBlocks.STELLAR_DIRT)
        .add(ModBlocks.STELLAR_PODZOL)
        .add(ModBlocks.FROZEN_STELLAR_GRASS);




    }
}
