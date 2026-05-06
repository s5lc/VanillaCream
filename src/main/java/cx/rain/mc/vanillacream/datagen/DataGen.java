package cx.rain.mc.vanillacream.datagen;

import com.klikli_dev.modonomicon.api.datagen.NeoBookProvider;
import cx.rain.mc.vanillacream.VanillaCream;
import cx.rain.mc.vanillacream.datagen.book.ModGuideBook;
import cx.rain.mc.vanillacream.datagen.language.ModEnUsProvider;
import cx.rain.mc.vanillacream.datagen.language.ModZhCnProvider;
import cx.rain.mc.vanillacream.registry.ModDatapackEntries;
import net.minecraft.client.data.models.ModelProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Map;
import java.util.Set;

@EventBusSubscriber(modid = VanillaCream.MOD_ID)
public class DataGen {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        var gen = event.getGenerator();
        var output = gen.getPackOutput();
        var registries = event.getLookupProvider();

        event.addProvider(new ModModelProvider(output, VanillaCream.MOD_ID));
        event.addProvider(new ModBlockTagsProvider(output, registries, VanillaCream.MOD_ID));
        event.addProvider(new ModItemTagsProvider(output, registries, VanillaCream.MOD_ID));
        event.addProvider(new ModEntityTagsProvider(output, registries, VanillaCream.MOD_ID));
        event.addProvider(new ModBiomeTagsProvider(output, registries, VanillaCream.MOD_ID));
        event.addProvider(new ModRecipeProvider.Runner(output, registries));
        event.addProvider(new DatapackBuiltinEntriesProvider(output, registries, ModDatapackEntries.BUILDER, Set.of(VanillaCream.MOD_ID)));

        {
            var enUsLang = new ModEnUsProvider(output, VanillaCream.MOD_ID, "en_us");
            var zhCnLang = new ModZhCnProvider(output, VanillaCream.MOD_ID, "zh_cn");

            event.addProvider(NeoBookProvider.of(
                    event,
                    new ModGuideBook("guide_book", VanillaCream.MOD_ID, enUsLang, Map.of("zh_cn", zhCnLang))));

            event.addProvider(enUsLang);
            event.addProvider(zhCnLang);
        }
    }
}
