package net.lxlennox.astralis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.SpringFeature;

import java.util.ArrayList;

public class ModItemGroups {

    private static ModItemGroups INSTANCE;
    public static ModItemGroups getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ModItemGroups();
        }
        return INSTANCE;
    }

    private final ArrayList<ItemStack> toAdd = new ArrayList<>();
    public static ItemGroup ASTRALIS_ITEM_GROUP = null;

   public void registerItemGroups() {
       Astralis.LOGGER.info("Registering Item Groups for " + Astralis.MOD_ID);
       ASTRALIS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
               Astralis.id("astralis_items"),
               FabricItemGroup.builder().icon(()->new ItemStack(ModBlocks.MOONVEIL_LOG))
                       .entries( (itemGroup, entries) -> {
                           entries.addAll(toAdd);
                       })
                       .displayName(Text.translatable("itemgroup.astralis.astralis")).build());
    }

    public void addToItemGroup(ItemStack item) {
        toAdd.add(item);
    }
}
