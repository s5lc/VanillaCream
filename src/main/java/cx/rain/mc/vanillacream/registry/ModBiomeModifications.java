package cx.rain.mc.vanillacream.registry;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static cx.rain.mc.vanillacream.util.IdentifierHelper.modLoc;

public class ModBiomeModifications {
    public static final ResourceKey<BiomeModifier> FLOWER_ROSE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, modLoc("flower_rose"));
    public static final ResourceKey<BiomeModifier> FLOWER_PAEONIA = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, modLoc("flower_paeonia"));

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(FLOWER_ROSE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(ModTags.Biome.HAS_ROSE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FLOWER_ROSE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(FLOWER_PAEONIA, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(ModTags.Biome.HAS_PAEONIA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FLOWER_PAEONIA)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
