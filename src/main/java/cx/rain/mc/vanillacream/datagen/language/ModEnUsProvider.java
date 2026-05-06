package cx.rain.mc.vanillacream.datagen.language;

import cx.rain.mc.vanillacream.registry.ModBlocks;
import cx.rain.mc.vanillacream.registry.ModCreativeModeTabs;
import cx.rain.mc.vanillacream.registry.ModItems;
import net.minecraft.data.PackOutput;

public class ModEnUsProvider extends ModLanguageProvider {
    public ModEnUsProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModCreativeModeTabs.TAB_TITLE_KEY, "Vanilla Cream!");

        addBlock(ModBlocks.ROSE, "Rose");
        addBlock(ModBlocks.CYAN_ROSE, "Cyan Rose");
        addBlock(ModBlocks.PAEONIA, "Paeonia");
        addBlock(ModBlocks.REDSTONE_JACK_O_LANTERN, "Redstone Jack o'Lantern");
        addBlock(ModBlocks.SOUL_JACK_O_LANTERN, "Soul Jack o'Lantern");
        addBlock(ModBlocks.COPPER_JACK_O_LANTERN, "Copper Jack o'Lantern");
        addItem(ModItems.BAGUETTE, "Baguette");
    }
}
