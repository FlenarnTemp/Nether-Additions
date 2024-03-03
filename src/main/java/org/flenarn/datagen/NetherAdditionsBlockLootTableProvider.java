package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import org.flenarn.block.NetherAdditionsBlocks;

import java.util.concurrent.CompletableFuture;

public class NetherAdditionsBlockLootTableProvider extends FabricBlockLootTableProvider {

    public NetherAdditionsBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(NetherAdditionsBlocks.CHISELED_BASALT);
        addDrop(NetherAdditionsBlocks.BASALT_TILES);
        addDrop(NetherAdditionsBlocks.BASALT_TILES_SLAB, slabDrops(NetherAdditionsBlocks.BASALT_TILES_SLAB));
        addDrop(NetherAdditionsBlocks.BASALT_BRICKS);
        addDrop(NetherAdditionsBlocks.BASALT_BRICK_WALL);
        addDrop(NetherAdditionsBlocks.BASALT_BRICK_STAIRS);
        addDrop(NetherAdditionsBlocks.BASALT_BRICK_SLAB, slabDrops(NetherAdditionsBlocks.BASALT_BRICK_SLAB));
        addDrop(NetherAdditionsBlocks.CRACKED_BASALT_BRICKS);
    }
}
