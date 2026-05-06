package cx.rain.mc.vanillacream.registry;

import cx.rain.mc.vanillacream.VanillaCream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = VanillaCream.MOD_ID)
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, VanillaCream.MOD_ID);

    public static final String TAB_TITLE_KEY = "itemGroup.vanillacream.tab";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = REGISTRY.register("tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(TAB_TITLE_KEY))
                    .icon(() -> new ItemStack(ModBlockItems.COPPER_JACK_O_LANTERN.get()))
                    .displayItems(ModCreativeModeTabs::fillModTab)
                    .build());

    public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }

    private static void fillModTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(ModBlockItems.REDSTONE_JACK_O_LANTERN);
        output.accept(ModBlockItems.SOUL_JACK_O_LANTERN);
        output.accept(ModBlockItems.COPPER_JACK_O_LANTERN);
        output.accept(ModBlockItems.ROSE);
        output.accept(ModBlockItems.CYAN_ROSE);
        output.accept(ModBlockItems.PAEONIA);
        output.accept(ModItems.BAGUETTE);
    }

    @SubscribeEvent
    public static void onBuildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlockItems.REDSTONE_JACK_O_LANTERN);
            event.accept(ModBlockItems.SOUL_JACK_O_LANTERN);
            event.accept(ModBlockItems.COPPER_JACK_O_LANTERN);
            return;
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlockItems.ROSE);
            event.accept(ModBlockItems.CYAN_ROSE);
            event.accept(ModBlockItems.PAEONIA);
            return;
        }

        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlockItems.REDSTONE_JACK_O_LANTERN);
            return;
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BAGUETTE);
            return;
        }
    }
}
