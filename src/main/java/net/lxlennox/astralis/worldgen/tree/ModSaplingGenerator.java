package net.lxlennox.astralis.worldgen.tree;

import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.worldgen.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerator {
        public static final SaplingGenerator MOONVEIL_TREE = new SaplingGenerator(Astralis.MOD_ID + ":moonveil_tree",
                Optional.empty(), Optional.of(ModConfiguredFeatures.MOONVEIL_TREE_KEY),
                Optional.empty());
}
