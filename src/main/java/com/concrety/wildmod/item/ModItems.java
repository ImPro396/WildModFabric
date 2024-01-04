package com.concrety.wildmod.item;

import com.concrety.wildmod.WildMod;
import com.concrety.wildmod.item.custom.MetalDetectorItem;
import com.concrety.wildmod.item.custom.PogoStickItem;
import com.concrety.wildmod.item.custom.SuperMetalDetectorItem;
import com.concrety.wildmod.item.custom.TerraformerItem;
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

    public static final Item RUBY = registerItem ("ruby", new Item(new FabricItemSettings ()));
    public static final Item RAW_RUBY = registerItem ("raw_ruby", new Item(new FabricItemSettings ()));
    public static final Item BUTTER = registerItem ("butter", new Item(new FabricItemSettings ().food (ModFoodComponents.BUTTER)));
    public static final Item METAL_DETECTOR = registerItem ("metal_detector", new MetalDetectorItem (new FabricItemSettings ().maxDamage (50)));
    public static final Item SUPER_METAL_DETECTOR = registerItem ("super_metal_detector", new SuperMetalDetectorItem(new FabricItemSettings ().maxDamage (200)));
    public static final Item POGO_STICK = registerItem ("pogo_stick", new PogoStickItem (new FabricItemSettings ().maxDamage (100)));
    public static final Item TERRAFORMER = registerItem ("terraformer", new TerraformerItem (new FabricItemSettings ().maxDamage (500)));
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
