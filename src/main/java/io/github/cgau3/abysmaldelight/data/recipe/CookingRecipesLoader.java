package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.init.ModItem;
import io.github.cgau3.abysmaldelight.init.ModItemTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

public class CookingRecipesLoader {
    public static void init(RegistrateRecipeProvider provider) {
        CookingPotRecipeBuilder.cookingPotRecipe(
                ModItem.LAVER_AND_EGG_SOUP_ITEM.get(),
                1,
                CookingRecipes.NORMAL_COOKING,
                CookingRecipes.SMALL_EXP,
                Items.BOWL
            )
            .addIngredient(ModItemTag.LAVER)
            .addIngredient(Tags.Items.EGGS)
            .unlockedByAnyIngredient(ModItem.LAVER_ITEM, ModItem.NORI_ITEM)
            .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
            .build(provider);
        CookingPotRecipeBuilder.cookingPotRecipe(
                ModItem.STEAMED_SCALLOP_ITEM.get(),
                1,
                CookingRecipes.NORMAL_COOKING,
                CookingRecipes.SMALL_EXP,
                ModItem.SHELL_ITEM
            )
            .addIngredient(ModItem.SCALLOP_MEAT_ITEM)
            .addIngredient(CommonTags.FOODS_ONION)
            .unlockedByAnyIngredient(ModItem.SCALLOP_MEAT_ITEM)
            .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
            .build(provider);
        CookingPotRecipeBuilder.cookingPotRecipe(
                ModItem.SEAFOOD_PORRIDGE_ITEM.get(),
                1,
                CookingRecipes.NORMAL_COOKING,
                CookingRecipes.MEDIUM_EXP,
                Items.BOWL
            )
            .addIngredient(ModItem.DIRED_SCALLOP_MEAT_ITEM)
            .addIngredient(ItemTags.FISHES)
            .addIngredient(CommonTags.FOODS_ONION)
            .addIngredient(ModItems.RICE.get())
            .unlockedByAnyIngredient(ModItem.DIRED_SCALLOP_MEAT_ITEM, ModItems.RICE.get())
            .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
            .build(provider);
        CookingPotRecipeBuilder.cookingPotRecipe(
                ModItem.SCALLOP_DANGENG_ITEM.get(),
                1,
                CookingRecipes.NORMAL_COOKING,
                CookingRecipes.SMALL_EXP,
                Items.BOWL
            )
            .addIngredient(ModItem.DIRED_SCALLOP_MEAT_ITEM)
            .addIngredient(Tags.Items.EGGS)
            .addIngredient(Tags.Items.EGGS)
            .unlockedByAnyIngredient(ModItem.DIRED_SCALLOP_MEAT_ITEM, Items.EGG.asItem())
            .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
            .build(provider);
    }
}
