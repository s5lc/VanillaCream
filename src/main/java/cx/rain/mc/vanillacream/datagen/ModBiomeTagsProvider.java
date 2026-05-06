package cx.rain.mc.vanillacream.datagen;

import cx.rain.mc.vanillacream.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class ModBiomeTagsProvider extends BiomeTagsProvider {
    public ModBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Biome.HAS_ROSE)
                .add(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.RIVER, Biomes.BEACH,
                        Biomes.SWAMP, Biomes.SPARSE_JUNGLE);
        tag(ModTags.Biome.HAS_PAEONIA)
                .add(Biomes.WINDSWEPT_FOREST, Biomes.MEADOW, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA)
                .addTag(BiomeTags.IS_SAVANNA);
    }
}
