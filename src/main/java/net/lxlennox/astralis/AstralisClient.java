package net.lxlennox.astralis;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.entity.ModBoats;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.biome.GrassColors;

public class AstralisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex)
                        -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getDefaultColor(),
                ModBlocks.STELLAR_GRASS_BLOCK);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return GrassColors.getDefaultColor();
        },ModBlocks.STELLAR_GRASS_BLOCK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex)
                        -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getDefaultColor(),
                ModBlocks.STELLAR_GRASS);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return GrassColors.getDefaultColor();
        },ModBlocks.STELLAR_GRASS);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex)
                        -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getDefaultColor(),
                ModBlocks.STELLAR_SPROUTS);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return GrassColors.getDefaultColor();
        },ModBlocks.STELLAR_SPROUTS);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.MOONVEIL_BOAT_ID,false);


        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.STELLAR_GRASS_BLOCK);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.MOONVEIL_LEAVES,
                ModBlocks.MOONVEIL_SAPLING,
                ModBlocks.MOONVEIL_DOOR,
                ModBlocks.MOONVEIL_TRAPDOOR,
                ModBlocks.POTTED_MOONVEIL_SAPLING,
                ModBlocks.FROSTBLOOM_PETALS,
                ModBlocks.STELLAR_GRASS,
                ModBlocks.SNOWBLOOM,
                ModBlocks.POTTED_SNOWBLOOM,
                ModBlocks.STELLAR_SPROUTS);




    }
}
