package com.concrety.wildmod.datagen;

import com.concrety.wildmod.block.ModBlocks;
import com.concrety.wildmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    protected ModLootTableProvider(FabricDataOutput dataOutput) {
        super (dataOutput);
    }

    @Override
    public void generate() {
        addDrop (ModBlocks.RUBY_BLOCK);
        addDrop (ModBlocks.RAW_RUBY_BLOCK);

        addDrop (ModBlocks.RUBY_ORE, lapisLikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY));
    }

    public LootTable.Builder lapisLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay
                (drop, ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create
                        (4.0f, 9.0f)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
