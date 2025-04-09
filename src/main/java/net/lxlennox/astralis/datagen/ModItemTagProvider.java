package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);

         getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                 .add(ModBlocks.MOONVEIL_LOG.asItem())
                 .add(ModBlocks.MOONVEIL_WOOD.asItem())
                 .add(ModBlocks.STRIPPED_MOONVEIL_WOOD.asItem())
                 .add(ModBlocks.STRIPPED_MOONVEIL_LOG.asItem());





    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

    }
}


