package com.concrety.wildmod;

import com.concrety.wildmod.block.ModBlocks;
import com.concrety.wildmod.customcodes.SheepShearCallback;
import com.concrety.wildmod.item.ModItemGroups;
import com.concrety.wildmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildMod implements ModInitializer {

	public static final String MOD_ID = "wildmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups ();

		ModItems.registerModItems ();
		ModBlocks.registerModBlocks ();
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
			BlockState state = world.getBlockState(pos);
            /* Manual spectator check is necessary because AttackBlockCallbacks
               fire before the spectator check */
			if (state.isToolRequired() && !player.isSpectator() &&
					player.getMainHandStack().isEmpty()) {
				player.teleport (0, 0, 0);
			}
			return ActionResult.PASS;
		});
	}
}