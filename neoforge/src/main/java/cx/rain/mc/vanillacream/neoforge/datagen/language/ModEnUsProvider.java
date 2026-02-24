package cx.rain.mc.vanillacream.neoforge.datagen.language;

import cx.rain.mc.vanillacream.registries.ModBlocks;
import cx.rain.mc.vanillacream.registries.ModCreativeModeTabs;
import cx.rain.mc.vanillacream.registries.ModItems;
import net.minecraft.data.PackOutput;

public class ModEnUsProvider extends ModLanguageProvider {
    public ModEnUsProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected void register() {
        addTab(ModCreativeModeTabs.TAB, "Vanilla Cream!");

        addBlock(ModBlocks.ROSE, "Rose");
        addBlock(ModBlocks.CYAN_ROSE, "Cyan Rose");
        addBlock(ModBlocks.PAEONIA, "Paeonia");
        addBlock(ModBlocks.REDSTONE_JACK_O_LANTERN, "Redstone Jack o'Lantern");
        addBlock(ModBlocks.SOUL_JACK_O_LANTERN, "Soul Jack o'Lantern");
        addItem(ModItems.BAGUETTE, "Baguette");
    }
}
