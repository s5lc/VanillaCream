package cx.rain.mc.vanillacream.neoforge.datagen;

import com.klikli_dev.modonomicon.api.datagen.NeoBookProvider;
import cx.rain.mc.vanillacream.VanillaCreamMod;
import cx.rain.mc.vanillacream.neoforge.datagen.book.ModGuideBook;
import cx.rain.mc.vanillacream.neoforge.datagen.language.ModEnUsProvider;
import cx.rain.mc.vanillacream.neoforge.datagen.language.ModZhCnProvider;
import cx.rain.mc.vanillacream.neoforge.registry.ModDatapackEntriesNeoForge;
import cx.rain.mc.vanillacream.registries.ModBlocks;
import cx.rain.mc.vanillacream.registries.ModItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

@EventBusSubscriber(modid = VanillaCreamMod.MOD_ID)
public class DataGen {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var existingFileHelper = event.getExistingFileHelper();
        var output = gen.getPackOutput();
        var registries = event.getLookupProvider();

        gen.addProvider(event.includeClient(), new ModBlockStateProvider(output, VanillaCreamMod.MOD_ID, existingFileHelper, List.of(ModBlocks.REGISTRY)));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, VanillaCreamMod.MOD_ID, existingFileHelper, List.of(ModItems.REGISTRY)));

        var blockTags = gen.addProvider(event.includeServer(), new ModBlockTagsProvider(output, registries, VanillaCreamMod.MOD_ID, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModItemTagsProvider(output, registries, blockTags.contentsGetter(), VanillaCreamMod.MOD_ID, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModBiomeTagsProvider(output, registries, VanillaCreamMod.MOD_ID, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModEntityTagsProvider(output, registries, VanillaCreamMod.MOD_ID, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(output, registries));
        gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, registries, ModDatapackEntriesNeoForge.BUILDER, Set.of(VanillaCreamMod.MOD_ID)));

        var enUsLang = new ModEnUsProvider(output, VanillaCreamMod.MOD_ID, "en_us");
        var zhCnLang = new ModZhCnProvider(output, VanillaCreamMod.MOD_ID, "zh_cn");

        {
            // Modonomicon book
            gen.addProvider(event.includeServer(), NeoBookProvider.of(
                    event,
                    new ModGuideBook("guide_book", VanillaCreamMod.MOD_ID, enUsLang, Map.of("zh_cn", zhCnLang))
            ));
        }

        gen.addProvider(event.includeClient(), enUsLang);
        gen.addProvider(event.includeClient(), zhCnLang);
    }
}
