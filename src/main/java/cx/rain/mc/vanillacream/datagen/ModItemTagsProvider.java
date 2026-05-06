package cx.rain.mc.vanillacream.datagen;

import cx.rain.mc.vanillacream.registry.ModBlockItems;
import cx.rain.mc.vanillacream.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Item.VANILLA_SMALL_FLOWERS).add(ModBlockItems.ROSE.get(), ModBlockItems.CYAN_ROSE.get(), ModBlockItems.PAEONIA.get());
    }
}
