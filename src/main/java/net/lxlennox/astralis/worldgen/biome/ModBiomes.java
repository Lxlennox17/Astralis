package net.lxlennox.astralis.worldgen.biome;

import net.lxlennox.astralis.Astralis;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;


public class ModBiomes {

    public static final RegistryKey<Biome> STELLAR_FIELDS = RegistryKey.of(RegistryKeys.BIOME,
           Astralis.id("stellar_fields"));

    public static final RegistryKey<Biome> MOONVEIL_WOODS = RegistryKey.of(RegistryKeys.BIOME,
           Astralis.id("moonveil_woods"));


    public static void bootstrap(Registerable<Biome> context) {
        context.register(STELLAR_FIELDS, stellarFields(context));
        context.register(MOONVEIL_WOODS, moonveilWoods(context));
    }

    private static Biome stellarFields(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        ModBiomes.addLandCarversAstralis(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.8F)
                .temperature(0.4F)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(6141935)
                        .waterFogColor(6141935)
                        .skyColor(8103167)
                        .fogColor(12638463)
                        .grassColor(11983713)
                        // .foliageColor( 0xCEB5F0)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_CHERRY_GROVE)).build())
                .build();
    }

    private static Biome moonveilWoods(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));


        ModBiomes.addLandCarversAstralis(biomeBuilder);
        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.7F)
                .temperature(0.8F)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(15395819)
                        .waterFogColor(14935011)
                        .skyColor(7039851)
                        .fogColor(14935011)
                        .grassColor(13888509)
                        .foliageColor(15395819)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_CHERRY_GROVE)).build())
                .build();
    }

    public static void addLandCarversAstralis(GenerationSettings.LookupBackedBuilder builder) {
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE);
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND);
        builder.feature(GenerationStep.Feature.LAKES, MiscPlacedFeatures.LAKE_LAVA_UNDERGROUND);
    }
}
