package cx.rain.mc.vanillacream.handlers;

import cx.rain.mc.vanillacream.VanillaCream;
import cx.rain.mc.vanillacream.block.RedstonePumpkinLanternBlock;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = VanillaCream.MOD_ID)
public class RedstonePumpkinLanternHandlers {
    @SubscribeEvent
    public static void onEntityTickPost(EntityTickEvent.Post event) {
        var entity = event.getEntity();
        if (entity instanceof ServerPlayer player) {
            var level = player.level();
            RedstonePumpkinLanternBlock.playerTick(player, level);
        }
    }
}
