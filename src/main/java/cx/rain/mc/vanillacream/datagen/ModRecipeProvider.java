package cx.rain.mc.vanillacream.datagen;

import cx.rain.mc.vanillacream.registry.ModBlockItems;
import cx.rain.mc.vanillacream.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

import static cx.rain.mc.vanillacream.util.IdentifierHelper.modLoc;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        // region Baguette

        shaped(RecipeCategory.FOOD, ModItems.BAGUETTE.get())
                .pattern("  W")
                .pattern(" W ")
                .pattern("W  ")
                .define('W', Items.WHEAT)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(output);

        // endregion


        // region Craftable stones

        shapeless(RecipeCategory.BUILDING_BLOCKS, Items.CALCITE, 2)
                .requires(Items.DIORITE)
                .requires(Items.DRIPSTONE_BLOCK)
                .unlockedBy("has_diorite", has(Items.DIORITE))
                .unlockedBy("has_dripstone_block", has(Items.DRIPSTONE_BLOCK))
                .save(output, modKey("calcite"));

        shapeless(RecipeCategory.BUILDING_BLOCKS, Items.TUFF, 2)
                .requires(Items.ANDESITE)
                .requires(Items.BASALT)
                .unlockedBy("has_andesite", has(Items.ANDESITE))
                .unlockedBy("has_basalt", has(Items.BASALT))
                .save(output, modKey("tuff"));

        shapeless(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE, 2)
                .requires(Items.STONE)
                .requires(Items.BASALT)
                .unlockedBy("has_stone", has(Items.STONE))
                .unlockedBy("has_basalt", has(Items.BASALT))
                .save(output, modKey("deepslate"));

        shaped(RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE, 8)
                .pattern("SSS")
                .pattern("SDS")
                .pattern("SSS")
                .define('S', Items.BASALT)
                .define('D', Items.BLACK_DYE)
                .unlockedBy("has_basalt", has(Items.BASALT))
                .unlockedBy("has_black_dye", has(Items.BLACK_DYE))
                .save(output, modKey("blackstone"));

        // endregion


        // region Jack o'Lanterns

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlockItems.REDSTONE_JACK_O_LANTERN.get())
                .pattern("C")
                .pattern("T")
                .define('C', Items.CARVED_PUMPKIN)
                .define('T', Items.REDSTONE_TORCH)
                .unlockedBy("has_carved_pumpkin", has(Items.CARVED_PUMPKIN))
                .unlockedBy("has_redstone_torch", has(Items.REDSTONE_TORCH))
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlockItems.SOUL_JACK_O_LANTERN.get())
                .pattern("C")
                .pattern("T")
                .define('C', Items.CARVED_PUMPKIN)
                .define('T', Items.SOUL_TORCH)
                .unlockedBy("has_carved_pumpkin", has(Items.CARVED_PUMPKIN))
                .unlockedBy("has_soul_torch", has(Items.SOUL_TORCH))
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlockItems.COPPER_JACK_O_LANTERN.get())
                .pattern("C")
                .pattern("T")
                .define('C', Items.CARVED_PUMPKIN)
                .define('T', Items.COPPER_TORCH)
                .unlockedBy("has_carved_pumpkin", has(Items.CARVED_PUMPKIN))
                .unlockedBy("has_copper_torch", has(Items.COPPER_TORCH))
                .save(output);

        // endregion
    }

    private static ResourceKey<Recipe<?>> modKey(String path) {
        return ResourceKey.create(Registries.RECIPE, modLoc(path));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        public String getName() {
            return "VanillaCream Recipes";
        }
    }
}
