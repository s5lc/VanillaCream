package cx.rain.mc.vanillacream.datagen;

import cx.rain.mc.vanillacream.registry.ModBlocks;
import cx.rain.mc.vanillacream.registry.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output, String modId) {
        super(output, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createPlantWithDefaultItem(ModBlocks.ROSE.get(), ModBlocks.POTTED_ROSE.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(ModBlocks.CYAN_ROSE.get(), ModBlocks.POTTED_CYAN_ROSE.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(ModBlocks.PAEONIA.get(), ModBlocks.POTTED_PAEONIA.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        blockModels.createPumpkinVariant(ModBlocks.REDSTONE_JACK_O_LANTERN.get(), TextureMapping.column(Blocks.PUMPKIN));
        blockModels.createPumpkinVariant(ModBlocks.SOUL_JACK_O_LANTERN.get(), TextureMapping.column(Blocks.PUMPKIN));
        blockModels.createPumpkinVariant(ModBlocks.COPPER_JACK_O_LANTERN.get(), TextureMapping.column(Blocks.PUMPKIN));

        itemModels.generateFlatItem(ModItems.BAGUETTE.get(), ModelTemplates.FLAT_ITEM);
    }
}
