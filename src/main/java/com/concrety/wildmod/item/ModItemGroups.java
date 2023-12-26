package com.concrety.wildmod.item;

import com.concrety.wildmod.WildMod;
import com.concrety.wildmod.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups implements ModInitializer {

    public static final ItemGroup MOD_ITEM_GROUP = Registry.register (Registries.ITEM_GROUP, new Identifier (WildMod.MOD_ID, "mod_items"),
            FabricItemGroup.builder().displayName (Text.translatable ("itemgroup.mod_items")).icon (() -> new ItemStack (ModItems.RUBY))
                    .entries ((displayContext, entries) -> {
                        entries.add (ModItems.RUBY);
                        entries.add (ModItems.RAW_RUBY);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        WildMod.LOGGER.info ("Registering Itemgroups for " + WildMod.LOGGER);
    }

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups ();
        ModItems.registerModItems ();
    }
}
