package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);



    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

           // Moonveil Plank Recipes

        List<ItemConvertible> MOONVEIL_PLANKS = List.of(
                ModBlocks.MOONVEIL_LOG,
                ModBlocks.MOONVEIL_WOOD,
                ModBlocks.STRIPPED_MOONVEIL_LOG,
                ModBlocks.STRIPPED_MOONVEIL_WOOD);

        for (ItemConvertible inputRedwood : MOONVEIL_PLANKS) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOONVEIL_PLANKS, 4)
                    .input(inputRedwood)
                    .criterion("has_" + inputRedwood.asItem().getTranslationKey(),
                            InventoryChangedCriterion.Conditions.items(inputRedwood.asItem()))
                    .offerTo(recipeExporter, Identifier.of(Astralis.MOD_ID, inputRedwood.asItem().getTranslationKey() + "_to_moonveil_planks"));






        }
    }
}
