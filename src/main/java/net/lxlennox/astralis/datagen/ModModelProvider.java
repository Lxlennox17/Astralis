package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;

import static net.lxlennox.astralis.block.ModBlocks.FROZEN_STELLAR_GRASS;
import static net.lxlennox.astralis.block.ModBlocks.STELLAR_PODZOL;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLAR_COBBLESTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_STELLARSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STELLARSLATE);


        blockStateModelGenerator.registerLog(ModBlocks.MOONVEIL_LOG).log(ModBlocks.MOONVEIL_LOG).wood(ModBlocks.MOONVEIL_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MOONVEIL_LOG).log(ModBlocks.STRIPPED_MOONVEIL_LOG).wood(ModBlocks.STRIPPED_MOONVEIL_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONVEIL_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MOONVEIL_SAPLING, ModBlocks.POTTED_MOONVEIL_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MOONVEIL_LOG, ModBlocks.MOONVEIL_HANGING_SIGN, ModBlocks.MOONVEIL_WALL_HANGING_SIGN);

        var redwoodFamily = new BlockFamily.Builder(ModBlocks.MOONVEIL_PLANKS)

                .button(ModBlocks.MOONVEIL_BUTTON)
                .fence(ModBlocks.MOONVEIL_FENCE)
                .fenceGate(ModBlocks.MOONVEIL_FENCE_GATE)
                .pressurePlate(ModBlocks.MOONVEIL_PRESSURE_PLATE)
                .sign(ModBlocks.MOONVEIL_SIGN,ModBlocks.MOONVEIL_WALL_SIGN)
                .slab(ModBlocks.MOONVEIL_SLAB)
                .stairs(ModBlocks.MOONVEIL_STAIRS)
                .door(ModBlocks.MOONVEIL_DOOR)
                .trapdoor(ModBlocks.MOONVEIL_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(redwoodFamily.getBaseBlock())
                .family(redwoodFamily);



        blockStateModelGenerator.registerCubeWithCustomTextures(FROZEN_STELLAR_GRASS, ModBlocks.STELLAR_DIRT, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(STELLAR_PODZOL, ModBlocks.STELLAR_DIRT, TextureMap::frontSideWithCustomBottom);

        blockStateModelGenerator.registerTintableCross(ModBlocks.STELLAR_GRASS, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.STELLAR_SPROUTS, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerFlowerbed(ModBlocks.FROSTBLOOM_PETALS);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SNOWBLOOM, ModBlocks.POTTED_SNOWBLOOM, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.MOONVEIL_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOONVEIL_CHEST_BOAT, Models.GENERATED);


    }
}