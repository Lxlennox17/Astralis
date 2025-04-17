package net.lxlennox.astralis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_STAIRS,4)
                .pattern("R11")
                .pattern("RR1")
                .pattern("RRR")
                .input('R',ModBlocks.MOONVEIL_PLANKS)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_SLAB,6)
                .pattern("RRR")
                .input('R',ModBlocks.MOONVEIL_PLANKS)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.MOONVEIL_BUTTON,1)
                .input(ModBlocks.MOONVEIL_PLANKS)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_PRESSURE_PLATE,1)
                .input(ModBlocks.MOONVEIL_PLANKS)
                .input(ModBlocks.MOONVEIL_PLANKS)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_FENCE,3)
                .pattern("RSR")
                .pattern("RSR")
                .input('R',ModBlocks.MOONVEIL_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_DOOR,3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R',ModBlocks.MOONVEIL_PLANKS)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_TRAPDOOR,12)
                .pattern("SRS")
                .pattern("SRS")
                .input('R',ModBlocks.MOONVEIL_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MOONVEIL_SIGN,3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("LSL")
                .input('R',ModBlocks.MOONVEIL_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.MOONVEIL_PLANKS),conditionsFromItem(ModBlocks.MOONVEIL_PLANKS))
                .offerTo(recipeExporter);




    }
}