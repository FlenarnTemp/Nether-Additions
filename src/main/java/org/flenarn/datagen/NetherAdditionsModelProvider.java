package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.Item;

import static org.flenarn.block.NetherAdditionsBlocks.*;
import static org.flenarn.item.NetherAdditionsItems.*;

public class NetherAdditionsModelProvider extends FabricModelProvider {
    public NetherAdditionsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool basalt_bricks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(BASALT_BRICKS);
        basalt_bricks_pool.wall(BASALT_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BASALT_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(CHISELED_BASALT);
        blockStateModelGenerator.registerAxisRotated(BASALT_TILES, TexturedModel.CUBE_COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Item[] itemsToRegisterGeneratedModel = {
                LAVACANTH,
                PYROLITHID,
                ECTOCARP,
                GOLDHEAD_WRASSE,
                LITHID_SOUP
        };

        for (Item item : itemsToRegisterGeneratedModel) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
