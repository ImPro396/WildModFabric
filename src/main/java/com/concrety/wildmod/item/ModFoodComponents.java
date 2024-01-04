package com.concrety.wildmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent BUTTER = new FoodComponent.Builder ().hunger (2).saturationModifier (.5f).statusEffect
            (new StatusEffectInstance (StatusEffects.HUNGER, 100), .5f).build();

}
