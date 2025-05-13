package net.lxlennox.astralis.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.entity.ModBoats;
import net.minecraft.block.*;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

//TODO: Add to creative ivn

    public static final Item LUNARIUM_INGOT = registerItem(
            "lunarium_ingot",
            new Item(new Item.Settings()),
            true
    );

    public static final Item RAW_LUNARIUM_INGOT = registerItem(
            "raw_lunarium_ingot",
            new Item(new Item.Settings()),
            true
    );

    public static final Item MOONVEIL_SIGN = registerItem(
        "moonveil_sign",
        new SignItem(new Item.Settings()
                .maxCount(16), ModBlocks.MOONVEIL_SIGN, ModBlocks.MOONVEIL_WALL_SIGN),
            true
    );

    public static final Item MOONVEIL_HANGING_SIGN = registerItem(
            "moonveil_hanging_sign",
            new HangingSignItem(ModBlocks.MOONVEIL_HANGING_SIGN, ModBlocks.MOONVEIL_WALL_HANGING_SIGN,
                    new Item.Settings().maxCount(16)),
            true
    );

    public static final Item MOONVEIL_BOAT = TerraformBoatItemHelper.registerBoatItem(
            ModBoats.MOONVEIL_BOAT_ID,ModBoats.MOONVEIL_BOAT_KEY, false
            );
    public static final Item MOONVEIL_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(
            ModBoats.MOONVEIL_CHEST_BOAT_ID, ModBoats.MOONVEIL_BOAT_KEY, true
            );

    private static Item registerItem(String name,Item item,boolean addToCreativeTab) {
        return Registry.register(Registries.ITEM, Identifier.of(Astralis.MOD_ID, name), item);

    }
  public static void registerModItems(){
        Astralis.LOGGER.info("registering ModItems for"+Astralis.MOD_ID);
    }
}
