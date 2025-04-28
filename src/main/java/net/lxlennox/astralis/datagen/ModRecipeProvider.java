package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.item.ModItems;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
                ModBlocks.STRIPPED_MOONVEIL_WOOD
        );

        for (ItemConvertible inputRedwood : MOONVEIL_PLANKS) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOONVEIL_PLANKS, 4)
                    .input(inputRedwood)
                    .criterion("has_" + inputRedwood.asItem().getTranslationKey(),
                            InventoryChangedCriterion.Conditions.items(inputRedwood.asItem()))
                    .offerTo(recipeExporter, Identifier.of(Astralis.MOD_ID, inputRedwood.asItem().getTranslationKey() + "_to_moonveil_planks"));
        }



        //Non Block Blocks

        createStairsRecipe(ModBlocks.MOONVEIL_STAIRS, Ingredient.ofItems(ModBlocks.MOONVEIL_PLANKS))
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS), conditionsFromItem(ModBlocks.MOONVEIL_PLANKS)).offerTo(recipeExporter);


        offerSlabRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.MOONVEIL_SLAB, ModBlocks.MOONVEIL_PLANKS);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.MOONVEIL_BUTTON,1)
                .input(ModBlocks.MOONVEIL_PLANKS)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_BUTTON))
                .offerTo(recipeExporter);

        offerPressurePlateRecipe(recipeExporter,ModBlocks.MOONVEIL_PRESSURE_PLATE,ModBlocks.MOONVEIL_PLANKS);


        createFenceRecipe(ModBlocks.MOONVEIL_FENCE,Ingredient.ofItems(ModBlocks.MOONVEIL_PLANKS))
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_FENCE)).offerTo(recipeExporter);


        createFenceGateRecipe(ModBlocks.MOONVEIL_FENCE_GATE,Ingredient.ofItems(ModBlocks.MOONVEIL_PLANKS))
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_FENCE_GATE)).offerTo(recipeExporter);


        createDoorRecipe(ModBlocks.MOONVEIL_DOOR,Ingredient.ofItems(ModBlocks.MOONVEIL_PLANKS))
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_DOOR)).offerTo(recipeExporter);


        createTrapdoorRecipe(ModBlocks.MOONVEIL_TRAPDOOR,Ingredient.ofItems(ModBlocks.MOONVEIL_PLANKS))
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_TRAPDOOR)).offerTo(recipeExporter);


        createSignRecipe(ModBlocks.MOONVEIL_SIGN,Ingredient.ofItems(ModBlocks.MOONVEIL_PLANKS))
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_SIGN))
                .offerTo(recipeExporter);

        offerHangingSignRecipe(recipeExporter,ModBlocks.MOONVEIL_HANGING_SIGN,ModBlocks.MOONVEIL_PLANKS);

        //Boats
        offerBoatRecipe(recipeExporter, ModItems.MOONVEIL_BOAT,ModBlocks.MOONVEIL_PLANKS);
        offerChestBoatRecipe(recipeExporter, ModItems.MOONVEIL_CHEST_BOAT,ModBlocks.MOONVEIL_PLANKS);

    }
}