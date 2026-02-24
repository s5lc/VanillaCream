package cx.rain.mc.vanillacream.neoforge.datagen.language;

import cx.rain.mc.vanillacream.registries.ModBlocks;
import cx.rain.mc.vanillacream.registries.ModCreativeModeTabs;
import cx.rain.mc.vanillacream.registries.ModItems;
import net.minecraft.data.PackOutput;

public class ModZhCnProvider extends ModLanguageProvider {
    public ModZhCnProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected void register() {
        addTab(ModCreativeModeTabs.TAB, "Vanilla Cream!");

        addBlock(ModBlocks.ROSE, "玫瑰");
        addBlock(ModBlocks.CYAN_ROSE, "青色玫瑰");
        addBlock(ModBlocks.PAEONIA, "芍药");
        addBlock(ModBlocks.REDSTONE_JACK_O_LANTERN, "红石南瓜灯");
        addBlock(ModBlocks.SOUL_JACK_O_LANTERN, "灵魂南瓜灯");
        addItem(ModItems.BAGUETTE, "法国长面包");
    }
}
