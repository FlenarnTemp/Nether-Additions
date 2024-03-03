package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import org.flenarn.block.NetherAdditionsBlocks;
import org.flenarn.item.NetherAdditionsItems;

import java.util.concurrent.CompletableFuture;

public class NetherAdditionsRecipeProvider extends FabricRecipeProvider {


    public NetherAdditionsRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, NetherAdditionsItems.LITHID_SOUP, 1)
                .input(NetherAdditionsItems.PYROLITHID)
                .input(Items.BOWL)
                .input(Items.WARPED_FUNGUS)
                .input(Items.NETHER_WART)
                .criterion(hasItem(NetherAdditionsItems.PYROLITHID), conditionsFromItem(NetherAdditionsItems.PYROLITHID))
                .criterion(hasItem(Items.WARPED_FUNGUS), conditionsFromItem(Items.WARPED_FUNGUS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.BASALT_BRICKS, 4)
                .pattern("SS")
                .pattern("SS")
                .input('S', Blocks.SMOOTH_BASALT)
                .criterion(hasItem(Blocks.SMOOTH_BASALT), conditionsFromItem(Blocks.SMOOTH_BASALT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.BASALT_BRICK_SLAB, 6)
                .pattern("SSS")
                .input('S', NetherAdditionsBlocks.BASALT_BRICKS)
                .criterion(hasItem(NetherAdditionsBlocks.BASALT_BRICKS), conditionsFromItem(NetherAdditionsBlocks.BASALT_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.BASALT_BRICK_WALL, 6)
                .pattern("SSS")
                .pattern("SSS")
                .input('S', NetherAdditionsBlocks.BASALT_BRICKS)
                .criterion(hasItem(NetherAdditionsBlocks.BASALT_BRICKS), conditionsFromItem(NetherAdditionsBlocks.BASALT_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.BASALT_BRICK_STAIRS, 4)
                .pattern("  S")
                .pattern(" SS")
                .pattern("SSS")
                .input('S', NetherAdditionsBlocks.BASALT_BRICKS)
                .criterion(hasItem(NetherAdditionsBlocks.BASALT_BRICKS), conditionsFromItem(NetherAdditionsBlocks.BASALT_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.BASALT_TILES, 4)
                .pattern("SS")
                .pattern("SS")
                .input('S', NetherAdditionsBlocks.BASALT_BRICKS)
                .criterion(hasItem(NetherAdditionsBlocks.BASALT_BRICKS), conditionsFromItem(NetherAdditionsBlocks.BASALT_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.BASALT_TILES_SLAB, 6)
                .pattern("SSS")
                .input('S', NetherAdditionsBlocks.BASALT_TILES)
                .criterion(hasItem(NetherAdditionsBlocks.BASALT_TILES), conditionsFromItem(NetherAdditionsBlocks.BASALT_TILES))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, NetherAdditionsBlocks.CHISELED_BASALT, 1)
                .pattern("S")
                .pattern("S")
                .input('S', NetherAdditionsBlocks.BASALT_BRICK_SLAB)
                .criterion(hasItem(NetherAdditionsBlocks.BASALT_BRICKS), conditionsFromItem(NetherAdditionsBlocks.BASALT_BRICKS))
                .offerTo(exporter);
    }
}
