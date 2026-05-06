package cx.rain.mc.vanillacream.registry;

import cx.rain.mc.vanillacream.VanillaCream;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(VanillaCream.MOD_ID);

    public static final DeferredItem<BlockItem> ROSE = REGISTRY.registerSimpleBlockItem(ModBlocks.ROSE);
    public static final DeferredItem<BlockItem> CYAN_ROSE = REGISTRY.registerSimpleBlockItem(ModBlocks.CYAN_ROSE);
    public static final DeferredItem<BlockItem> PAEONIA = REGISTRY.registerSimpleBlockItem(ModBlocks.PAEONIA);

    public static final DeferredItem<BlockItem> REDSTONE_JACK_O_LANTERN = REGISTRY.registerSimpleBlockItem(ModBlocks.REDSTONE_JACK_O_LANTERN);
    public static final DeferredItem<BlockItem> SOUL_JACK_O_LANTERN = REGISTRY.registerSimpleBlockItem(ModBlocks.SOUL_JACK_O_LANTERN);
    public static final DeferredItem<BlockItem> COPPER_JACK_O_LANTERN = REGISTRY.registerSimpleBlockItem(ModBlocks.COPPER_JACK_O_LANTERN);

    public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }
}
