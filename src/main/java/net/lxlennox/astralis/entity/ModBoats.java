package net.lxlennox.astralis.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {

    public static final Identifier MOONVEIL_BOAT_ID = Identifier.of(Astralis.MOD_ID,"moonveil_boat");
    public static final Identifier MOONVEIL_CHEST_BOAT_ID = Identifier.of(Astralis.MOD_ID,"moonveil_chest_boat");
    public static final RegistryKey<TerraformBoatType> MOONVEIL_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MOONVEIL_BOAT_ID);

    public static TerraformBoatType MOONVEIL_TYPE;



    public static TerraformBoatType register(RegistryKey<TerraformBoatType> key, TerraformBoatType type) {
        return Registry.register(TerraformBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void load() {
        MOONVEIL_TYPE = register(MOONVEIL_BOAT_KEY, new TerraformBoatType.Builder()
                .item(ModItems.MOONVEIL_BOAT)
                .chestItem(ModItems.MOONVEIL_CHEST_BOAT)
                .planks(ModBlocks.MOONVEIL_PLANKS.asItem())
                .build());
    }
}