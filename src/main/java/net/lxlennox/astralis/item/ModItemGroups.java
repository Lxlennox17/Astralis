package net.lxlennox.astralis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ASTRALIS_ITEM_GROUP= Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Astralis.MOD_ID,"astralis_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModBlocks.MOONVEIL_LOG))
                    .displayName(Text.translatable("itemgroup.astralis.astralis"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.STELLAR_GRASS);
                        entries.add(ModBlocks.STELLAR_DIRT);
                        entries.add(ModBlocks.STELLAR_PODZOL);
                        entries.add(ModBlocks.FROZEN_STELLAR_GRASS);

                        entries.add(ModBlocks.MOONVEIL_LOG);
                        entries.add(ModBlocks.MOONVEIL_WOOD);
                        entries.add(ModBlocks.STRIPPED_MOONVEIL_LOG);
                        entries.add(ModBlocks.STRIPPED_MOONVEIL_WOOD);
                        entries.add(ModBlocks.MOONVEIL_PLANKS);


                        entries.add(ModBlocks.MOONVEIL_LEAVES);
                        entries.add(ModBlocks.MOONVEIL_SAPLING);





                    }).build());








   public static void registerItemGroups() {
        Astralis.LOGGER.info("Registering Item Groups for " + Astralis.MOD_ID);

    }
}
