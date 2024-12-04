package org.flenarn.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import org.flenarn.NetherAdditions;

public class NetherAdditionsBlocks {

    public static final Block CHISELED_BASALT = registerBlockWithItem("chiseled_basalt", new Block(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("chiseled_basalt")))));

    public static final Block BASALT_TILES = registerBlockWithItem("basalt_tiles", new PillarBlock(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("basalt_tiles")))));
    public static final Block BASALT_TILES_SLAB = registerBlockWithItem("basalt_tiles_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("basalt_tiles_slab")))));

    public static final Block BASALT_BRICKS = registerBlockWithItem("basalt_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("basalt_bricks")))));
    public static final Block BASALT_BRICK_SLAB = registerBlockWithItem("basalt_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("basalt_brick_slab")))));
    public static final Block BASALT_BRICK_STAIRS = registerBlockWithItem("basalt_brick_stairs", new StairsBlock(BASALT_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("basalt_brick_stairs")))));
    public static final Block BASALT_BRICK_WALL = registerBlockWithItem("basalt_brick_wall", new WallBlock(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("basalt_brick_wall")))));

    public static final Block CRACKED_BASALT_BRICKS = registerBlockWithItem("cracked_basalt_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BASALT).registryKey(RegistryKey.of(RegistryKeys.BLOCK, NetherAdditions.getModId("cracked_basalt_bricks")))));
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, NetherAdditions.getModId(name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId(name)))));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, NetherAdditions.getModId(name), block);
    }

    public static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlock(name, block);
    }

    public static void registerBlocks() {
        NetherAdditions.LOGGER.info("Registering blocks for " + NetherAdditions.MOD_ID + ".");
    }
}

