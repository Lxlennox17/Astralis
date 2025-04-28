package net.lxlennox.astralis;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.entity.ModBoats;
import net.lxlennox.astralis.item.ModItemGroups;
import net.lxlennox.astralis.item.ModItems;
import net.lxlennox.astralis.worldgen.gen.ModWorldGeneration;
import net.lxlennox.astralis.worldgen.tree.ModFoliagePlacerTypes;
import net.lxlennox.astralis.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.block.Blocks;

import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Astralis implements ModInitializer {
	public static final String MOD_ID = "astralis";
	public static Logger LOGGER = null;

	@Override
	public void onInitialize() {
		LOGGER = LoggerFactory.getLogger(MOD_ID);
		initRegistries();

		// register portal
		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.CRYING_OBSIDIAN)
				.lightWithFluid(Fluids.LAVA)
				.destDimID(Astralis.id("astralisdim"))
				.tintColor(0xc76efa)
				.registerPortal();
	}

	private void initRegistries() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();
		ModItemGroups.getInstance().registerItemGroups();
		ModTrunkPlacerTypes.registerAstralisTrunkPlacerType();
		ModFoliagePlacerTypes.register();
		ModBoats.load();

		FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
		// registering flammable blocks
		flammableBlockRegistry.add(ModBlocks.MOONVEIL_LOG, 5, 5);
		flammableBlockRegistry.add(ModBlocks.MOONVEIL_WOOD, 5, 5);
		flammableBlockRegistry.add(ModBlocks.STRIPPED_MOONVEIL_LOG, 5, 5);
		flammableBlockRegistry.add(ModBlocks.STRIPPED_MOONVEIL_WOOD, 5, 5);
		flammableBlockRegistry.add(ModBlocks.MOONVEIL_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOONVEIL_LEAVES, 30, 60);

		// registering the strippable blocks
		StrippableBlockRegistry.register(ModBlocks.MOONVEIL_LOG,ModBlocks.STRIPPED_MOONVEIL_LOG);
		StrippableBlockRegistry.register(ModBlocks.MOONVEIL_WOOD,ModBlocks.STRIPPED_MOONVEIL_WOOD);
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}