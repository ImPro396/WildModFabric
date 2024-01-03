package com.concrety.wildmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PogoStickItem extends Item {

    public PogoStickItem(Settings settings) {
        super(settings);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            int yspeed;
            if (!world.isClient) {
                PlayerEntity closestPlayer = world.getClosestPlayer(entity, 100);
                if (closestPlayer != null) {
                    closestPlayer.setMovementSpeed (500);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SLIME_JUMP, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }
    }
}
