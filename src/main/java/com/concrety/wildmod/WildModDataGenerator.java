package com.concrety.wildmod;

import com.concrety.wildmod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class WildModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack ();

		pack.addProvider (ModBlockTagProvider::new);
		pack.addProvider (ModLootTableProvider::new);
		pack.addProvider (ModModelProvider::new);
		pack.addProvider (ModRecipeProvider::new);
	}
}