package com.concrety.wildmod.block;

import com.concrety.wildmod.WildMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock ("ruby_block",
            new Block (FabricBlockSettings.copyOf (Blocks.EMERALD_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock ("raw_ruby_block",
            new Block (FabricBlockSettings.copyOf (Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_ORE = registerBlock ("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf (Blocks.STONE).strength(2f), UniformIntProvider.create (2, 5)));
    public static final Block RUBY_STAIRS = registerBlock ("ruby_stairs",
            new StairsBlock (ModBlocks.RUBY_BLOCK.getDefaultState (),FabricBlockSettings.copyOf (Blocks.EMERALD_BLOCK)));
    public static final Block RUBY_SLAB = registerBlock ("ruby_slab",
            new SlabBlock (FabricBlockSettings.copyOf (Blocks.EMERALD_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem (name, block);
        return Registry.register (Registries.BLOCK, new Identifier (WildMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register (Registries.ITEM, new Identifier (WildMod.MOD_ID, name),
                new BlockItem (block, new FabricItemSettings ()));
    }

    public static void registerModBlocks() {
        WildMod.LOGGER.info ("Registering ModBlocks for " + WildMod.MOD_ID);
    }

}