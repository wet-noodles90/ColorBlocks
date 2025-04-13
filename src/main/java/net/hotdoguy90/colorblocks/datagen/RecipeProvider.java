package net.hotdoguy90.colorblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hotdoguy90.colorblocks.block.ColorBlock;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ColorBlock.COLOR_BLOCK_ITEM, 3)
                .pattern("RLQ")
                .pattern("GL#")
                .pattern("BLQ")
                .input('R', Items.RED_STAINED_GLASS)
                .input('L', Items.REDSTONE_LAMP)
                .input('Q', Items.QUARTZ)
                .input('G', Items.GREEN_STAINED_GLASS)
                .input('#', Items.REDSTONE)
                .input('B', Items.BLUE_STAINED_GLASS)
                .criterion(hasItem(Items.RED_STAINED_GLASS), conditionsFromItem(Items.RED_STAINED_GLASS))
                .criterion(hasItem(Items.REDSTONE_LAMP), conditionsFromItem(Items.REDSTONE_LAMP))
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .criterion(hasItem(Items.GREEN_STAINED_GLASS), conditionsFromItem(Items.GREEN_STAINED_GLASS))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(Items.BLUE_STAINED_GLASS), conditionsFromItem(Items.BLUE_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ColorBlock.COLOR_BLOCK_ITEM)));
    }
}
