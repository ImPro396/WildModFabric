package com.concrety.wildmod.mixin;

import com.concrety.wildmod.customcodes.SheepShearCallback;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
		SheepShearCallback.EVENT.register((player, sheep) -> {
			sheep.setSheared(true);

			// create diamond item entity at sheep position
			ItemStack stack = new ItemStack(Items.DIAMOND);
			ItemEntity itemEntity = new ItemEntity(player.getWorld (), sheep.getX(), sheep.getY (), sheep.getZ (), stack);
			player.getWorld ().spawnEntity(itemEntity);

			return ActionResult.FAIL;
		});
	}
}