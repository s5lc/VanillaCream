package cx.rain.mc.vanillacream.registry;

import cx.rain.mc.vanillacream.VanillaCream;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(VanillaCream.MOD_ID);

    public static final DeferredItem<Item> BAGUETTE = REGISTRY.registerItem("baguette",
            Item::new,
            () -> new Item.Properties().food(ModFoods.BAGUETTE));

    public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }
}
