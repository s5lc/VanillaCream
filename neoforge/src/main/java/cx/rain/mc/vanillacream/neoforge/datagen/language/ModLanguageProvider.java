package cx.rain.mc.vanillacream.neoforge.datagen.language;

import com.klikli_dev.modonomicon.api.datagen.ModonomiconLanguageProvider;
import games.moegirl.sinocraft.sinocore.neoforge.api.datagen.AbstractLanguageProvider;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public abstract class ModLanguageProvider extends AbstractLanguageProvider implements ModonomiconLanguageProvider {
    public ModLanguageProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    public void accept(String key, String value) {
        add(key, value);
    }

    @Override
    public @NotNull Map<String, String> data() {
        // Todo: sinocore should provide a getData. But this method was not used actually.
        return Map.of();
    }
}
