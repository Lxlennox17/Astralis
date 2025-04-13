package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STELLAR_DIRT);
        addDropWithSilkTouch(ModBlocks.STELLAR_GRASS,ModBlocks.STELLAR_DIRT);
        addDropWithSilkTouch(ModBlocks.STELLAR_PODZOL,ModBlocks.STELLAR_DIRT);
        addDropWithSilkTouch(ModBlocks.FROZEN_STELLAR_GRASS,ModBlocks.STELLAR_DIRT);

        addDrop(ModBlocks.MOONVEIL_LOG);
        addDrop(ModBlocks.MOONVEIL_WOOD);
        addDrop(ModBlocks.STRIPPED_MOONVEIL_LOG);
        addDrop(ModBlocks.STRIPPED_MOONVEIL_WOOD);
        addDrop(ModBlocks.MOONVEIL_SAPLING);

        addDrop(ModBlocks.MOONVEIL_LEAVES, leavesDrops(ModBlocks.MOONVEIL_LEAVES, ModBlocks.MOONVEIL_SAPLING, 0.0625f));
    }
}
