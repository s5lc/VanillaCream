package cx.rain.mc.vanillacream.registry;

import cx.rain.mc.vanillacream.VanillaCream;
import cx.rain.mc.vanillacream.block.RedstonePumpkinLanternBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("deprecation")
public class ModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(VanillaCream.MOD_ID);

    public static final DeferredBlock<FlowerBlock> ROSE = REGISTRY.registerBlock("rose",
            props -> new FlowerBlock(MobEffects.DARKNESS, 3, props),
            ModBlocks::flowerProps
    );
    public static final DeferredBlock<FlowerBlock> CYAN_ROSE = REGISTRY.registerBlock("cyan_rose",
            props -> new FlowerBlock(MobEffects.NIGHT_VISION, 7, props),
            ModBlocks::flowerProps
    );
    public static final DeferredBlock<FlowerBlock> PAEONIA = REGISTRY.registerBlock("paeonia",
            props -> new FlowerBlock(MobEffects.HASTE, 11, props),
            ModBlocks::flowerProps
    );

    public static final DeferredBlock<Block> POTTED_ROSE = REGISTRY.registerBlock("potted_rose",
            props -> new FlowerPotBlock(ROSE.get(), props),
            Blocks::flowerPotProperties);
    public static final DeferredBlock<Block> POTTED_CYAN_ROSE = REGISTRY.registerBlock("potted_cyan_rose",
            props -> new FlowerPotBlock(CYAN_ROSE.get(), props),
            Blocks::flowerPotProperties);
    public static final DeferredBlock<Block> POTTED_PAEONIA = REGISTRY.registerBlock("potted_paeonia",
            props -> new FlowerPotBlock(PAEONIA.get(), props),
            Blocks::flowerPotProperties);

    public static final DeferredBlock<Block> REDSTONE_JACK_O_LANTERN = REGISTRY.registerBlock("redstone_jack_o_lantern",
            RedstonePumpkinLanternBlock::new,
            () -> pumpkinLanternProps(8));
    public static final DeferredBlock<Block> SOUL_JACK_O_LANTERN = REGISTRY.registerBlock("soul_jack_o_lantern",
            CarvedPumpkinBlock::new,
            () -> pumpkinLanternProps(11));
    public static final DeferredBlock<Block> COPPER_JACK_O_LANTERN = REGISTRY.registerBlock("copper_jack_o_lantern",
            CarvedPumpkinBlock::new,
            () -> pumpkinLanternProps(15));

    public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }

    private static BlockBehaviour.Properties flowerProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollision()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties pumpkinLanternProps(int lightLevel) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_ORANGE)
                .strength(1.0F)
                .sound(SoundType.WOOD)
                .lightLevel(_ -> lightLevel)
                .isValidSpawn(Blocks::always)
                .pushReaction(PushReaction.DESTROY);
    }
}
