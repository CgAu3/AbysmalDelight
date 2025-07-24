package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.data.AbysmalDataGen;
import io.github.cgau3.abysmaldelight.init.ModItem;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class VanillaRecipesLoader {
    public static void init(RegistrateRecipeProvider provider) {
        /*
        //example:
         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.HEART_OF_THE_SEA)
            .pattern("A")
            .pattern("B")
            .pattern("A")
            .define('A', ModItems.SEA_HEART_SHELL)
            .define('B', ModItems.SAPPHIRE)
            .unlockedBy("hasitem", AnvilCraftDatagen.has(ModItems.SEA_HEART_SHELL))
            .save(provider);
         */
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItem.LAVER_ITEM), RecipeCategory.FOOD,
                ModItem.NORI_ITEM, 0.35f, 300)
            .unlockedBy(AbysmalDataGen.hasItem(ModItem.LAVER_ITEM.get()), AbysmalDataGen.has(ModItem.LAVER_ITEM))
            .save(provider, AbysmalDelight.of("campfire_cooking_nori"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItem.LAVER_ITEM), RecipeCategory.FOOD,
                ModItem.NORI_ITEM, 0.35f, 100)
            .unlockedBy(AbysmalDataGen.hasItem(ModItem.LAVER_ITEM.get()), AbysmalDataGen.has(ModItem.LAVER_ITEM))
            .save(provider, AbysmalDelight.of("smoking_nori"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItem.LAVER_ITEM), RecipeCategory.FOOD,
                ModItem.NORI_ITEM, 0.35f, 200)
            .unlockedBy(AbysmalDataGen.hasItem(ModItem.LAVER_ITEM.get()), AbysmalDataGen.has(ModItem.LAVER_ITEM))
            .save(provider, AbysmalDelight.of("smelting_nori"));
    }
}
