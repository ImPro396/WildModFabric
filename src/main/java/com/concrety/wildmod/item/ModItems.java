package com.concrety.wildmod.item;

import com.concrety.wildmod.WildMod;
import com.concrety.wildmod.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem ("ruby", new Item(new FabricItemSettings ())); //Ruby Item
    public static final Item RAW_RUBY = registerItem ("raw_ruby", new Item(new FabricItemSettings ())); //Raw Ruby Item
    public static final Item METAL_DETECTOR = registerItem ("metal_detector", new MetalDetectorItem (new FabricItemSettings ().maxDamage (50))); //Raw Ruby Item
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add (RUBY);
        entries.add (RAW_RUBY);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register (Registries.ITEM, new Identifier (WildMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        WildMod.LOGGER.info("Registering Mod Items for " + WildMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent (ItemGroups.INGREDIENTS).register (ModItems::addItemsToIngredientItemGroup);
    }
}
