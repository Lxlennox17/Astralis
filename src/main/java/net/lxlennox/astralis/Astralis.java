package net.lxlennox.astralis;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import net.lxlennox.astralis.block.ModBlocks;
import net.lxlennox.astralis.item.ModItemGroups;
import net.lxlennox.astralis.item.ModItems;
import net.lxlennox.astralis.world.gen.ModWorldGeneration;
import net.lxlennox.astralis.world.tree.ModFoliagePlacerTypes;
import net.lxlennox.astralis.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.Blocks;

import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Astralis implements ModInitializer {
	public static final String MOD_ID = "astralis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();
		ModItemGroups.registerItemGroups();
		ModTrunkPlacerTypes.registerAstralisTrunkPlacerType();
		ModFoliagePlacerTypes.register();








		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.CRYING_OBSIDIAN)
				.lightWithFluid(Fluids.LAVA)
				.destDimID(Identifier.of(Astralis.MOD_ID,"astralisdim"))
				.tintColor(0xc76efa)
				.registerPortal();




		StrippableBlockRegistry.register(ModBlocks.MOONVEIL_LOG,ModBlocks.STRIPPED_MOONVEIL_LOG);
		StrippableBlockRegistry.register(ModBlocks.MOONVEIL_WOOD,ModBlocks.STRIPPED_MOONVEIL_WOOD);



		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOONVEIL_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOONVEIL_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MOONVEIL_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MOONVEIL_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MOONVEIL_PLANKS, 5, 20);
		//FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.REDWOOD_LEAVES, 30, 60);









	}
}