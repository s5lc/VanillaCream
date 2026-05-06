package cx.rain.mc.vanillacream.registry;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BAGUETTE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6F)
            .build();
}
