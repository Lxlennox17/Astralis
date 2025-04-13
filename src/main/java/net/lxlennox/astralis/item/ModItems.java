package net.lxlennox.astralis.item;

import net.lxlennox.astralis.Astralis;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

  private static Item registerItem(String name,Item item){
     return Registry.register(Registries.ITEM, Identifier.of(Astralis.MOD_ID,name),item);
  }

  public static void registerModItems(){
        Astralis.LOGGER.info("registering ModItems for"+Astralis.MOD_ID);
    }
}
