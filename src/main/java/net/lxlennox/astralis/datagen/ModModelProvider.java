package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

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
blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MOONVEIL_SAPLING,ModBlocks.POTTED_SHADOW_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);




    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }
}