package org.flenarn.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.flenarn.NetherAdditions;

public class NetherAdditionsBlocks {

    public static final Block CHISELED_BASALT = registerBlockWithItem("chiseled_basalt", new Block(AbstractBlock.Settings.copy(Blocks.BASALT)));

    public static final Block BASALT_TILES = registerBlockWithItem("basalt_tiles", new PillarBlock(AbstractBlock.Settings.copy(Blocks.BASALT)));
    public static final Block BASALT_TILES_SLAB = registerBlockWithItem("basalt_tiles_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.BASALT)));

    public static final Block BASALT_BRICKS = registerBlockWithItem("basalt_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BASALT)));
    public static final Block BASALT_BRICK_SLAB = registerBlockWithItem("basalt_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.BASALT)));
    public static final Block BASALT_BRICK_STAIRS = registerBlockWithItem("basalt_brick_stairs", new StairsBlock(BASALT_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BASALT)));
    public static final Block BASALT_BRICK_WALL = registerBlockWithItem("basalt_brick_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.BASALT)));

    public static final Block CRACKED_BASALT_BRICKS = registerBlockWithItem("cracked_basalt_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BASALT)));
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NetherAdditions.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(NetherAdditions.MOD_ID, name), block);
    }

    public static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlock(name, block);
    }

    public static void registerBlocks() {
        NetherAdditions.LOGGER.info("Registering blocks for " + NetherAdditions.MOD_ID + ".");
    }
}

