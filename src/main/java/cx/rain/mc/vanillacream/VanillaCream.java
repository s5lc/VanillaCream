package cx.rain.mc.vanillacream;

import cx.rain.mc.vanillacream.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(VanillaCream.MOD_ID)
public class VanillaCream {
    public static final String MOD_ID = "vanillacream";

    public VanillaCream(IEventBus bus) {
        ModBlocks.register(bus);
        ModBlockItems.register(bus);
        ModItems.register(bus);
        ModCreativeModeTabs.register(bus);
    }
}
