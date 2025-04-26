package net.lxlennox.astralis.item;

import net.lxlennox.astralis.Astralis;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

//TODO: Add to creative ivn
    public static final Item MOONVEIL_BOAT = registerItem(
            "moonveil_boat",
            new BoatItem(false, BoatEntity.Type.OAK,new Item.Settings().maxCount(1))
    );

    public static final Item MOONVEIL_CHEST_BOAT = registerItem(
            "moonveil_chest_boat",
            new BoatItem(true, BoatEntity.Type.OAK,new Item.Settings().maxCount(1))
    );

    private static Item registerItem(String name,Item item){
     return Registry.register(Registries.ITEM, Identifier.of(Astralis.MOD_ID,name),item);
  }

  public static void registerModItems(){
        Astralis.LOGGER.info("registering ModItems for"+Astralis.MOD_ID);
    }
}
