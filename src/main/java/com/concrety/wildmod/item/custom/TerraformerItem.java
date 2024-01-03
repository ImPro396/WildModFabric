package com.concrety.wildmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;

public class TerraformerItem extends Item {
    public TerraformerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            BlockState state = context.getWorld().getBlockState(positionClicked);
            PlayerEntity player = context.getPlayer();
            Block newBlock = getNewBlock(state);
            if(!(newBlock == null)) {
                if(!(newBlock == Blocks.CACTUS)) {
                    context.getWorld().setBlockState(positionClicked, newBlock.getDefaultState());
                    context.getStack().damage(1, context.getPlayer(),
                            playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                }else {
                    if(context.getWorld().getBlockState(positionClicked.down(1)) == Blocks.GRASS_BLOCK.getDefaultState()) {
                        context.getWorld().setBlockState(positionClicked.down (1), Blocks.SAND.getDefaultState());
                    }if(context.getWorld().getBlockState(positionClicked.down(2)) == Blocks.GRASS_BLOCK.getDefaultState()) {
                        context.getWorld().setBlockState(positionClicked.down (2), Blocks.SAND.getDefaultState());
                    }if(context.getWorld().getBlockState(positionClicked.down(1)) == Blocks.TALL_GRASS.getDefaultState()) {
                        context.getWorld().setBlockState(positionClicked.down (1), Blocks.CACTUS.getDefaultState());
                    }if(context.getWorld().getBlockState(positionClicked.up(1)) == Blocks.TALL_GRASS.getDefaultState()) {
                        context.getWorld().setBlockState(positionClicked.up (1), Blocks.CACTUS.getDefaultState());
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    private Block getNewBlock(BlockState state) {
        Block result = null;
        if (state.isOf(Blocks.GRASS_BLOCK)) {
            result = Blocks.SAND;
        }else if (state.isOf(Blocks.SAND)) {
            result = Blocks.GRASS_BLOCK;
        }else if (state.isOf(Blocks.SANDSTONE)) {
            result = Blocks.STONE;
        }else if (state.isOf(Blocks.STONE)) {
            result = Blocks.SANDSTONE;
        }else if (state.isOf(Blocks.GRASS)) {
            result = Blocks.DEAD_BUSH;
        }else if (state.isOf(Blocks.DEAD_BUSH)) {
            result = Blocks.GRASS;
        }else if (state.isOf(Blocks.TALL_GRASS)) {
            result = Blocks.CACTUS;
        }else if (state.isOf(Blocks.CACTUS)) {
            result = Blocks.TALL_GRASS;
        }
        return result;
    }

}