package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import org.flenarn.item.NetherAdditionsItems;

public class NetherAdditionsRecipeProvider extends FabricRecipeProvider {
    public NetherAdditionsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, NetherAdditionsItems.WEEPING_FISHING_ROD, 1)
                .pattern("  G")
                .pattern(" SW")
                .pattern("S W")
                .input('S', Items.STICK)
                .input('G', Items.GOLD_INGOT)
                .input('W', Items.WEEPING_VINES)
                .criterion(hasItem(Items.WEEPING_VINES), conditionsFromItem(Items.WEEPING_VINES))
                .offerTo(exporter);
    }
}
