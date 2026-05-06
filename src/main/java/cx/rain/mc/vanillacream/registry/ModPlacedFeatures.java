package cx.rain.mc.vanillacream.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.TrapezoidInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.Arrays;

import static cx.rain.mc.vanillacream.util.IdentifierHelper.modLoc;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> FLOWER_ROSE = ResourceKey.create(Registries.PLACED_FEATURE, modLoc("flower_rose"));
    public static final ResourceKey<PlacedFeature> FLOWER_PAEONIA = ResourceKey.create(Registries.PLACED_FEATURE, modLoc("flower_paeonia"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        placedFlower(context, FLOWER_ROSE, ModConfiguredFeatures.FLOWER_ROSE);
        placedFlower(context, FLOWER_PAEONIA, ModConfiguredFeatures.FLOWER_PAEONIA);
    }

    private static void placed(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placements) {
        PlacementUtils.register(context, key, feature, Arrays.asList(placements));
    }

    private static void placedFlower(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature) {
        var featureHolder = context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(feature);
        placed(context, key, featureHolder,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(32),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome(),
                RandomOffsetPlacement.of(TrapezoidInt.of(-6, 6, 0), TrapezoidInt.of(-2, 2, 0)),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(ModTags.Block.VANILLA_AIR)));
    }
}
