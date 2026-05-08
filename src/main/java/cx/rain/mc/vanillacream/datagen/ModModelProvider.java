package cx.rain.mc.vanillacream.datagen;

import cx.rain.mc.vanillacream.block.RedstonePumpkinLanternBlock;
import cx.rain.mc.vanillacream.registry.ModBlocks;
import cx.rain.mc.vanillacream.registry.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output, String modId) {
        super(output, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createPlantWithDefaultItem(ModBlocks.ROSE.get(), ModBlocks.POTTED_ROSE.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(ModBlocks.CYAN_ROSE.get(), ModBlocks.POTTED_CYAN_ROSE.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModels.createPlantWithDefaultItem(ModBlocks.PAEONIA.get(), ModBlocks.POTTED_PAEONIA.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        {
            var textures = TextureMapping.column(Blocks.PUMPKIN);

            var normalTextures = textures.copyAndUpdate(TextureSlot.FRONT, TextureMapping.getBlockTexture(ModBlocks.REDSTONE_JACK_O_LANTERN.get()));
            var normalVariant = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ORIENTABLE.create(ModBlocks.REDSTONE_JACK_O_LANTERN.get(), normalTextures, blockModels.modelOutput));
            var invertedModelLoc = ModelLocationUtils.getModelLocation(ModBlocks.REDSTONE_JACK_O_LANTERN.get(), "_inverted");
            var invertedTextures = textures.copyAndUpdate(TextureSlot.FRONT, TextureMapping.getBlockTexture(ModBlocks.REDSTONE_JACK_O_LANTERN.get(), "_inverted"));
            var invertedVariant = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ORIENTABLE.create(invertedModelLoc, invertedTextures, blockModels.modelOutput));
            blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.REDSTONE_JACK_O_LANTERN.get())
                    .with(PropertyDispatch.initial(RedstonePumpkinLanternBlock.INVERTED)
                            .select(false, normalVariant)
                            .select(true, invertedVariant))
                    .with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));

            blockModels.createPumpkinVariant(ModBlocks.SOUL_JACK_O_LANTERN.get(), textures);
            blockModels.createPumpkinVariant(ModBlocks.COPPER_JACK_O_LANTERN.get(), textures);
        }

        itemModels.generateFlatItem(ModItems.BAGUETTE.get(), ModelTemplates.FLAT_ITEM);
    }
}
