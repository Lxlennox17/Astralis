package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STELLAR_DIRT);
        addDropWithSilkTouch(ModBlocks.STELLAR_GRASS_BLOCK, ModBlocks.STELLAR_DIRT);
        addDropWithSilkTouch(ModBlocks.STELLAR_PODZOL, ModBlocks.STELLAR_DIRT);
        addDropWithSilkTouch(ModBlocks.FROZEN_STELLAR_GRASS, ModBlocks.STELLAR_DIRT);

        addDrop(ModBlocks.MOONVEIL_LOG);
        addDrop(ModBlocks.MOONVEIL_WOOD);
        addDrop(ModBlocks.STRIPPED_MOONVEIL_LOG);
        addDrop(ModBlocks.STRIPPED_MOONVEIL_WOOD);
        addDrop(ModBlocks.MOONVEIL_SAPLING);
        addDrop(ModBlocks.MOONVEIL_STAIRS);
        addDrop(ModBlocks.MOONVEIL_BUTTON);
        addDrop(ModBlocks.MOONVEIL_PRESSURE_PLATE);
        addDrop(ModBlocks.MOONVEIL_FENCE);
        addDrop(ModBlocks.MOONVEIL_FENCE_GATE);
        addDrop(ModBlocks.MOONVEIL_SLAB,slabDrops(ModBlocks.MOONVEIL_SLAB));
        addDrop(ModBlocks.MOONVEIL_SIGN, ModItems.MOONVEIL_SIGN);
        addDrop(ModBlocks.MOONVEIL_WALL_SIGN, ModItems.MOONVEIL_SIGN);
        addDrop(ModBlocks.MOONVEIL_HANGING_SIGN, ModItems.MOONVEIL_HANGING_SIGN);
        addDrop(ModBlocks.MOONVEIL_WALL_HANGING_SIGN, ModItems.MOONVEIL_HANGING_SIGN);
        addDrop(ModBlocks.MOONVEIL_TRAPDOOR);
        addDrop(ModBlocks.MOONVEIL_DOOR,doorDrops(ModBlocks.MOONVEIL_DOOR));

        addDrop(ModBlocks.FROSTBLOOM_PETALS);



        addDrop(ModBlocks.MOONVEIL_LEAVES, leavesDrops(ModBlocks.MOONVEIL_LEAVES, ModBlocks.MOONVEIL_SAPLING, 0.0625f));


        addDrop(ModBlocks.STELLAR_GRASS, shortPlantDrops(ModBlocks.STELLAR_GRASS));
        addDrop(ModBlocks.STELLAR_SPROUTS, shortPlantDrops(ModBlocks.STELLAR_SPROUTS));
    }
}