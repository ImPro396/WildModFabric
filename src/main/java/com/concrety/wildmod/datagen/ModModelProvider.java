package com.concrety.wildmod.datagen;

import com.concrety.wildmod.block.ModBlocks;
import com.concrety.wildmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super (output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.RAW_RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.RUBY_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register (ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register (ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register (ModItems.BUTTER, Models.GENERATED);
        itemModelGenerator.register (ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register (ModItems.SUPER_METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register (ModItems.POGO_STICK, Models.GENERATED);
    }
}
