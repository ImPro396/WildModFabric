package com.concrety.wildmod;

import com.concrety.wildmod.item.ModItemGroups;
import com.concrety.wildmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildMod implements ModInitializer {

	public static final String MOD_ID = "wildmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems ();
		ModItemGroups.registerItemGroups ();
	}
}