package cx.rain.mc.vanillacream.datagen.book;

import com.klikli_dev.modonomicon.api.datagen.SingleBookSubProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookModel;

import java.util.Map;
import java.util.function.BiConsumer;

public class ModGuideBook extends SingleBookSubProvider {
    public ModGuideBook(String bookId,
                        String modId,
                        BiConsumer<String, String> defaultLang,
                        Map<String, BiConsumer<String, String>> translations) {
        super(bookId, modId, defaultLang, translations);
    }

    @Override
    protected BookModel additionalSetup(BookModel book) {
        add(lang("zh_cn"), context().bookName(), "VanillaCream模组指南");
        add(lang("zh_cn"), context().bookTooltip(), "VanillaCream添加了一些原版风格的内容。");
        return super.additionalSetup(book);
    }

    @Override
    protected void registerDefaultMacros() {

    }

    @Override
    protected void generateCategories() {

    }

    @Override
    protected String bookName() {
        return "Vanilla Cream Guide";
    }

    @Override
    protected String bookTooltip() {
        return "VanillaCream is a Minecraft mod with something vanilla-styled.";
    }
}
