package net.lxlennox.astralis.block;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.custom.StellarGrassBlock;
import net.lxlennox.astralis.item.ModItemGroups;
import net.lxlennox.astralis.worldgen.tree.ModSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;


public class ModBlocks {

    public static final Block STELLAR_GRASS_BLOCK = registerBlock(
            "stellar_grass_block",
            new StellarGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK))
    ,true);

    public static final Block STELLAR_DIRT = registerBlock(
            "stellar_dirt",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS))
            ,true);

    public static final Block STELLAR_PODZOL = registerBlock(
            "stellar_podzol",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS))
            ,true);

    public static final Block FROZEN_STELLAR_GRASS = registerBlock(
            "frozen_stellar_grass",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS))
            ,true);

    public static final Block MOONVEIL_LOG = registerBlock(
            "moonveil_log",
            Blocks.createLogBlock(MapColor.TERRACOTTA_CYAN, MapColor.TERRACOTTA_ORANGE)
            ,true );

    public static final Block STRIPPED_MOONVEIL_LOG = registerBlock(
            "stripped_moonveil_log",
            Blocks.createLogBlock(MapColor.TERRACOTTA_ORANGE,MapColor.TERRACOTTA_ORANGE)
            ,true);

    public static final Block MOONVEIL_WOOD = registerBlock(
            "moonveil_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable())
            ,true);

       public static final Block STRIPPED_MOONVEIL_WOOD = registerBlock(
               "stripped_moonveil_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable())
               ,true);

       public static final Block MOONVEIL_PLANKS = registerBlock(
               "moonveil_planks",
               new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                       .mapColor(MapColor.TERRACOTTA_ORANGE))
               ,true);

        public static final Block MOONVEIL_LEAVES = registerBlock(
                "moonveil_leaves",
                new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)
                        .mapColor(MapColor.WHITE))
                ,true );

    public static final Block MOONVEIL_SAPLING = registerBlock(
            "moonveil_sapling",
            new SaplingBlock(ModSaplingGenerator.MOONVEIL_TREE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING))
            ,true);

    public static final Block POTTED_MOONVEIL_SAPLING = Registry.register(Registries.BLOCK,
            Astralis.id("potted_moonveil_sapling"),
            new FlowerPotBlock(MOONVEIL_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_SPRUCE_SAPLING)
                    .nonOpaque())
    );

    public static final Block STELLAR_GRASS = registerBlock(
            "stellar_grass",
            new ShortPlantBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY))
            ,true);

    public static final Block STELLAR_SPROUTS = registerBlock(
            "stellar_sprouts",
            new ShortPlantBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY))
            ,true);

    //Non-Block Blocks

    public static final Block MOONVEIL_STAIRS = registerBlock(
            "moonveil_stairs",
            new StairsBlock(ModBlocks.MOONVEIL_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.OAK_STAIRS))
            ,true);
    public static final Block MOONVEIL_SLAB = registerBlock(
            "moonveil_slab",
            new SlabBlock(
                    AbstractBlock.Settings.copy(Blocks.OAK_SLAB))
            ,true);

    public static final Block MOONVEIL_BUTTON = registerBlock(
            "moonveil_button",
            new ButtonBlock(BlockSetType.OAK,30,AbstractBlock.Settings.copy(Blocks.OAK_BUTTON))
            ,true);


    public static final Block MOONVEIL_PRESSURE_PLATE = registerBlock(
            "moonveil_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE))
            ,true);

    public static final Block MOONVEIL_FENCE = registerBlock(
            "moonveil_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE))
            ,true);

    public static final Block MOONVEIL_FENCE_GATE = registerBlock(
            "moonveil_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE))
            ,true);

    public static final Block MOONVEIL_DOOR = registerBlock(
            "moonveil_door",
            new DoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_DOOR))
            ,true);

    public static final Block MOONVEIL_TRAPDOOR = registerBlock(
            "moonveil_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR))
            ,true);

    public static final Block MOONVEIL_SIGN =registerBlock(
            "moonveil_sign",
            new SignBlock(WoodType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_SIGN)),true);

    public static final Block MOONVEIL_HANGING_SIGN =registerBlock(
            "moonveil_hanging_sign",
            new HangingSignBlock(WoodType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)),true);


    // util methods
    private static Block registerBlock(String name, Block block, boolean addToCreativeTab) {
        registerBlockItem(name, block, addToCreativeTab);
        return Registry.register(Registries.BLOCK,Astralis.id(name), block);
    }

    private static void registerBlockItem(String name, Block block, boolean addToCreativeTab) {
        Registry.register(Registries.ITEM, Astralis.id(name),
                new BlockItem(block, new Item.Settings()));
        if (addToCreativeTab)
            ModItemGroups.getInstance().addToItemGroup(block.asItem().getDefaultStack());
    }

    public static void registerModBlocks() {
        Astralis.LOGGER.info("Registering Mod Blocks for " + Astralis.MOD_ID);
    }
}
