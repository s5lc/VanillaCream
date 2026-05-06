package cx.rain.mc.vanillacream.datagen.language;

import com.klikli_dev.modonomicon.api.datagen.ModonomiconLanguageProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.HashMap;
import java.util.Map;

public abstract class ModLanguageProvider extends LanguageProvider implements ModonomiconLanguageProvider {
    private final Map<String, String> languageEntries = new HashMap<>();

    public ModLanguageProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    public void add(String key, Component value) {
        super.add(key, value);
        languageEntries.put(key, value.getString());
    }

    @Override
    public void accept(String key, String value) {
        add(key, value);
    }

    @Override
    public Map<String, String> data() {
        return languageEntries;
    }
}
