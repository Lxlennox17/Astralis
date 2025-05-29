package net.lxlennox.astralis.tag;

import net.lxlennox.astralis.Astralis;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static final TagKey<Block> STELLAR_STONE_ORE_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK,
            Identifier.of(Astralis.MOD_ID,
                    "stellar_stone_ore_replaceables")
    );
    public static final TagKey<Block> STELLARSLATE_ORE_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK,
            Identifier.of(Astralis.MOD_ID,
                    "stellarslate_ore_replaceables")
    );


    public static void registerModTags() {
        Astralis.LOGGER.info("registering ModTags for" + Astralis.MOD_ID);
    }
}
