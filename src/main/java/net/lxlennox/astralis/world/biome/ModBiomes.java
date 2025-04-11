package net.lxlennox.astralis.world.biome;

import net.lxlennox.astralis.Astralis;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;


public class ModBiomes {

    public static final RegistryKey<Biome> STELLAR_FIELDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Astralis.MOD_ID, "stellar_fields"));

    public static final RegistryKey<Biome> MOONVEIL_WOODS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(Astralis.MOD_ID, "moonveil_woods"));





    public static void bootstrap(Registerable<Biome> context) {
   context.register(STELLAR_FIELDS,stellarFields(context));
 context.register(MOONVEIL_WOODS,moonveilWoods(context));



    }

    private static Biome stellarFields(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

       DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
     
        DefaultBiomeFeatures.addLandCarvers(biomeBuilder);


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

            DefaultBiomeFeatures.addLandCarvers(biomeBuilder);


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
    }

