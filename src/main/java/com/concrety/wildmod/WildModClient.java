package com.concrety.wildmod;

import com.concrety.wildmod.customcodes.SheepShearCallback;
import com.concrety.wildmod.customcodes.WorldTickCallback;
import com.google.common.eventbus.Subscribe;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class WildModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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
