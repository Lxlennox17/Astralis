package net.lxlennox.astralis.block;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.custom.StellarGrassBlock;
import net.lxlennox.astralis.world.tree.ModSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block STELLAR_GRASS = registerBlock("stellar_grass",
            new StellarGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)));

    public static final Block STELLAR_DIRT = registerBlock("stellar_dirt",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)));

    public static final Block MOONVEIL_LOG =registerBlock("moonveil_log",
    Blocks.createLogBlock(MapColor.TERRACOTTA_CYAN,MapColor.TERRACOTTA_ORANGE));

    public static final Block STRIPPED_MOONVEIL_LOG= registerBlock("stripped_moonveil_log",
            Blocks.createLogBlock(MapColor.TERRACOTTA_ORANGE,MapColor.TERRACOTTA_ORANGE));

    public static final Block MOONVEIL_WOOD=registerBlock("moonveil_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

       public static final Block STRIPPED_MOONVEIL_WOOD=registerBlock("stripped_moonveil_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));

       public static final Block MOONVEIL_PLANKS=registerBlock("moonveil_planks",
               new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                       .mapColor(MapColor.TERRACOTTA_ORANGE)));

public static final Block MOONVEIL_LEAVES=registerBlock("moonveil_leaves",
        new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)
                .mapColor(MapColor.WHITE)));

    public static final Block MOONVEIL_SAPLING = registerBlock("moonveil_sapling",
            new SaplingBlock(ModSaplingGenerator.MOONVEIL_TREE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block POTTED_SHADOW_SAPLING=Registry.register(Registries.BLOCK,Identifier.of(Astralis.MOD_ID,"potted_moonveil_sapling"),
            new FlowerPotBlock(MOONVEIL_SAPLING,AbstractBlock.Settings.copy(Blocks.POTTED_SPRUCE_SAPLING).nonOpaque()));






    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Astralis.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Astralis.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Astralis.LOGGER.info("Registering Mod Blocks for " + Astralis.MOD_ID);


    }
}
