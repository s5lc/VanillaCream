package cx.rain.mc.vanillacream.datagen;

import cx.rain.mc.vanillacream.registry.ModBlocks;
import cx.rain.mc.vanillacream.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Block.VANILLA_SMALL_FLOWERS).add(ModBlocks.ROSE.get(), ModBlocks.CYAN_ROSE.get(), ModBlocks.PAEONIA.get());
        tag(ModTags.Block.VANILLA_FLOWER_POTS).add(ModBlocks.POTTED_ROSE.get(), ModBlocks.POTTED_CYAN_ROSE.get(), ModBlocks.POTTED_PAEONIA.get());
    }
}
