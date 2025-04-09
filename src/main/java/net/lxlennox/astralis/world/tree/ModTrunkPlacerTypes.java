package net.lxlennox.astralis.world.tree;

import com.mojang.serialization.MapCodec;
import net.lxlennox.astralis.Astralis;
import net.lxlennox.astralis.world.tree.custom.MoonveilTreeTrunkPlacer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    //there are a trunk placer register
    public static final TrunkPlacerType<?> MOONVEIL_TREE_TRUNK_PLACER = registerTrunkPlacer(
            "moonveil_tree_trunk_placer", MoonveilTreeTrunkPlacer.CODEC);
    private static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunkPlacer(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE, id, new TrunkPlacerType<>(codec));
    }
    public static void registerAstralisTrunkPlacerType() {
        Astralis.LOGGER.info("Trunk placers registering for:" + Astralis.MOD_ID);
    }
}
