package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import org.flenarn.block.NetherAdditionsBlocks;

import java.util.concurrent.CompletableFuture;

public class NetherAdditionsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public NetherAdditionsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(NetherAdditionsBlocks.BASALT_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(NetherAdditionsBlocks.BASALT_BRICK_WALL)
                .add(NetherAdditionsBlocks.BASALT_BRICK_STAIRS)
                .add(NetherAdditionsBlocks.BASALT_BRICK_SLAB)
                .add(NetherAdditionsBlocks.BASALT_BRICKS)
                .add(NetherAdditionsBlocks.CRACKED_BASALT_BRICKS)
                .add(NetherAdditionsBlocks.BASALT_TILES)
                .add(NetherAdditionsBlocks.BASALT_TILES_SLAB)
                .add(NetherAdditionsBlocks.CHISELED_BASALT);
    }
}
