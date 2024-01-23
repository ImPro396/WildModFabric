package com.concrety.wildmod.datagen;

import com.concrety.wildmod.block.ModBlocks;
import com.concrety.wildmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static List<ItemConvertible> RUBY_SMELTIES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super (output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting (exporter, RUBY_SMELTIES, RecipeCategory.MISC, ModItems.RUBY, 1.0f, 175, "ruby");
        offerBlasting (exporter, RUBY_SMELTIES, RecipeCategory.MISC, ModItems.RUBY, 1.0f, 70, "ruby");

        offerReversibleCompactingRecipes (exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.MISC, ModBlocks.RUBY_BLOCK);
    }
}
