package net.lxlennox.astralis.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.block.custom.StellarGrassBlock;
import net.lxlennox.astralis.item.ModItemGroups;
import net.lxlennox.astralis.worldgen.tree.ModSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlocks {

    public static final Block STELLAR_GRASS_BLOCK = registerBlock(
            "stellar_grass_block",
            new StellarGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block STELLAR_DIRT = registerBlock(
            "stellar_dirt",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS))
    );

    public static final Block STELLAR_PODZOL = registerBlock(
            "stellar_podzol",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS))
    );

    public static final Block FROZEN_STELLAR_GRASS = registerBlock(
            "frozen_stellar_grass",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS))
    );

    public static final Block STELLAR_STONE = registerBlock(
            "stellar_stone",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE))
    );

    public static final Block STELLAR_COBBLESTONE = registerBlock(
            "stellar_cobblestone",
            new Block(AbstractBlock.Settings.copy(Blocks.COBBLESTONE))
    );

    public static final Block STELLARSLATE = registerBlock(
            "stellarslate",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE))
    );

    public static final Block COBBLED_STELLARSLATE = registerBlock(
            "cobbled_stellarslate",
            new Block(AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE))
    );

    public static final Block MOONVEIL_LOG = registerBlock(
            "moonveil_log",
            Blocks.createLogBlock(MapColor.TERRACOTTA_CYAN, MapColor.TERRACOTTA_ORANGE)
    );

    public static final Block STRIPPED_MOONVEIL_LOG = registerBlock(
            "stripped_moonveil_log",
            Blocks.createLogBlock(MapColor.TERRACOTTA_ORANGE,MapColor.TERRACOTTA_ORANGE)
    );

    public static final Block MOONVEIL_WOOD = registerBlock(
            "moonveil_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable())
    );

       public static final Block STRIPPED_MOONVEIL_WOOD = registerBlock(
               "stripped_moonveil_wood",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable())
       );

       public static final Block MOONVEIL_PLANKS = registerBlock(
               "moonveil_planks",
               new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                       .mapColor(MapColor.TERRACOTTA_ORANGE))
       );

        public static final Block MOONVEIL_LEAVES = registerBlock(
                "moonveil_leaves",
                new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)
                        .mapColor(MapColor.WHITE))
        );

    public static final Block MOONVEIL_SAPLING = registerBlock(
            "moonveil_sapling",
            new SaplingBlock(ModSaplingGenerator.MOONVEIL_TREE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING))
    );

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
    );

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
    );

    //Non-Block Blocks

    public static final Block MOONVEIL_STAIRS = registerBlock(
            "moonveil_stairs",
            new StairsBlock(ModBlocks.MOONVEIL_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.OAK_STAIRS))
    );
    public static final Block MOONVEIL_SLAB = registerBlock(
            "moonveil_slab",
            new SlabBlock(
                    AbstractBlock.Settings.copy(Blocks.OAK_SLAB))
    );

    public static final Block MOONVEIL_BUTTON = registerBlock(
            "moonveil_button",
            new ButtonBlock(BlockSetType.OAK,30,AbstractBlock.Settings.copy(Blocks.OAK_BUTTON))
    );


    public static final Block MOONVEIL_PRESSURE_PLATE = registerBlock(
            "moonveil_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE))
    );

    public static final Block MOONVEIL_FENCE = registerBlock(
            "moonveil_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE))
    );

    public static final Block MOONVEIL_FENCE_GATE = registerBlock(
            "moonveil_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE))
    );

    public static final Block MOONVEIL_DOOR = registerBlock(
            "moonveil_door",
            new DoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_DOOR)
                    .nonOpaque())
    );

    public static final Block MOONVEIL_TRAPDOOR = registerBlock(
            "moonveil_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)
                    .nonOpaque())
    );

    private static final Identifier MOONVEIL_SIGN_TEXTURE = Identifier.of(Astralis.MOD_ID,
            "entity/signs/moonveil"
    );

    private static final Identifier MOONVEIL_HANGING_SIGN_TEXTURE = Identifier.of(Astralis.MOD_ID,
            "entity/signs/hanging/moonveil"
    );

    private static final Identifier MOONVEIL_HANGING_SIGN_GUI_TEXTURE = Identifier.of(Astralis.MOD_ID,
            "textures/gui/hanging_signs/moonveil"
    );

    public static final TerraformSignBlock MOONVEIL_SIGN = Registry.register(Registries.BLOCK,Identifier.of(Astralis.MOD_ID,
                    "moonveil_sign"),
            new TerraformSignBlock(MOONVEIL_SIGN_TEXTURE, AbstractBlock.Settings.create()
                            .mapColor(MOONVEIL_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable())
    );

    public static final TerraformWallSignBlock MOONVEIL_WALL_SIGN =Registry.register(Registries.BLOCK,Identifier.of(Astralis.MOD_ID,
                    "moonveil_wall_sign"),
            new TerraformWallSignBlock(MOONVEIL_SIGN_TEXTURE, AbstractBlock.Settings.create()
                            .mapColor(MOONVEIL_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable())
    );

    public static final TerraformHangingSignBlock MOONVEIL_HANGING_SIGN = Registry.register(Registries.BLOCK,Identifier.of(Astralis.MOD_ID,
                    "moonveil_hanging_sign"),
            new TerraformHangingSignBlock(MOONVEIL_HANGING_SIGN_TEXTURE, MOONVEIL_HANGING_SIGN_GUI_TEXTURE,AbstractBlock.Settings.create()
                            .mapColor(MOONVEIL_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable())
    );

    public static final TerraformWallHangingSignBlock MOONVEIL_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK,Identifier.of(Astralis.MOD_ID,
                    "moonveil_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(MOONVEIL_HANGING_SIGN_TEXTURE, MOONVEIL_HANGING_SIGN_GUI_TEXTURE,AbstractBlock.Settings.create()
                            .mapColor(MOONVEIL_PLANKS.getDefaultMapColor())
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable())
    );

    public static final Block FROSTBLOOM_PETALS = registerBlock(
            "frostbloom_petals",
            new FlowerbedBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .sounds(BlockSoundGroup.PINK_PETALS)
                    .pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block SNOWBLOOM=registerBlock(
            "snowbloom",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE,10,AbstractBlock.Settings.copy(Blocks.LILY_OF_THE_VALLEY)
                    .nonOpaque().noCollision())
    );

    public static final Block POTTED_SNOWBLOOM=Registry.register(Registries.BLOCK,Identifier.of(Astralis.MOD_ID,
                    "potted_snowbloom"),
            new FlowerPotBlock(SNOWBLOOM,AbstractBlock.Settings.copy(Blocks.POTTED_LILY_OF_THE_VALLEY)
                    .nonOpaque())
    );

    public static final Block LUNARIUM_ORE = registerBlock(
            "lunarium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)
                    .requiresTool())
    );

    public static final Block STELLARSLATE_LUNARIUM_ORE = registerBlock(
            "stellarslate_lunarium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE))
    );

    public static final Block LUNARIUM_BLOCK=registerBlock(
            "lunarium_block",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK))
    );

    public static final Block RAW_LUNARIUM_BLOCK=registerBlock(
            "raw_lunarium_block",
            new Block(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS))
    );


    // util methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block, true);
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
