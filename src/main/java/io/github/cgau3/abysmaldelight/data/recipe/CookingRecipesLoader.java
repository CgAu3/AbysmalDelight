package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.init.ModItem;
import io.github.cgau3.abysmaldelight.init.ModItemTag;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
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
    }
}
