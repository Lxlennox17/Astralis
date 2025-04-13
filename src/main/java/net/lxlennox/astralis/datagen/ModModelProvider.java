package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

import static net.lxlennox.astralis.block.ModBlocks.FROZEN_STELLAR_GRASS;
import static net.lxlennox.astralis.block.ModBlocks.STELLAR_PODZOL;
import static net.minecraft.util.Identifier.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_DIRT);

        blockStateModelGenerator.registerLog(ModBlocks.MOONVEIL_LOG).log(ModBlocks.MOONVEIL_LOG).wood(ModBlocks.MOONVEIL_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MOONVEIL_LOG).log(ModBlocks.STRIPPED_MOONVEIL_LOG).wood(ModBlocks.STRIPPED_MOONVEIL_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONVEIL_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONVEIL_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MOONVEIL_SAPLING, ModBlocks.POTTED_SHADOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerCubeWithCustomTextures(FROZEN_STELLAR_GRASS, ModBlocks.STELLAR_DIRT, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(STELLAR_PODZOL, ModBlocks.STELLAR_DIRT, TextureMap::frontSideWithCustomBottom);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }
}