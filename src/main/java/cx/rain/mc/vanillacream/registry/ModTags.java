package cx.rain.mc.vanillacream.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import static cx.rain.mc.vanillacream.util.IdentifierHelper.mcLoc;
import static cx.rain.mc.vanillacream.util.IdentifierHelper.modLoc;

public class ModTags {
    public static class Block {
        public static final TagKey<net.minecraft.world.level.block.Block> VANILLA_SMALL_FLOWERS = TagKey.create(Registries.BLOCK, mcLoc("small_flowers"));
        public static final TagKey<net.minecraft.world.level.block.Block> VANILLA_FLOWER_POTS = TagKey.create(Registries.BLOCK, mcLoc("flower_pots"));

        public static final TagKey<net.minecraft.world.level.block.Block> VANILLA_AIR = TagKey.create(Registries.BLOCK, mcLoc("air"));
    }

    public static class Item {
        public static final TagKey<net.minecraft.world.item.Item> VANILLA_SMALL_FLOWERS = TagKey.create(Registries.ITEM, mcLoc("small_flowers"));
    }

    public static class Biome {
        public static final TagKey<net.minecraft.world.level.biome.Biome> HAS_ROSE = TagKey.create(Registries.BIOME, modLoc("has_rose"));
        public static final TagKey<net.minecraft.world.level.biome.Biome> HAS_PAEONIA = TagKey.create(Registries.BIOME, modLoc("has_paeonia"));
    }

    public static class Entity {
        public static final TagKey<EntityType<?>> CAN_GROW = TagKey.create(Registries.ENTITY_TYPE, modLoc("can_grow"));
        public static final TagKey<EntityType<?>> HAS_BABY = TagKey.create(Registries.ENTITY_TYPE, modLoc("has_baby"));
    }
}
