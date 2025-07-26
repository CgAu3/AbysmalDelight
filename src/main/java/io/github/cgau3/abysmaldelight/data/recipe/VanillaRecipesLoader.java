package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.data.AbysmalDataGen;
import io.github.cgau3.abysmaldelight.init.ModItem;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.registry.ModItems;

public class VanillaRecipesLoader {
    public static void init(RegistrateRecipeProvider provider) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItem.LAVER_ROLL_ITEM)
            .pattern("BCD")
            .pattern("AAA")
            .define('A', ModItem.NORI_ITEM)
            .define('B', ModItems.COOKED_RICE.get())
            .define('C', Items.CARROT)
            .define('D', ModItems.FRIED_EGG.get())
            .unlockedBy("has_item", AbysmalDataGen.has(ModItem.NORI_ITEM))
            .save(provider);
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
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItem.SCALLOP_MEAT_ITEM), RecipeCategory.FOOD,
                ModItem.DIRED_SCALLOP_MEAT_ITEM, 0.35f, 500)
            .unlockedBy(AbysmalDataGen.hasItem(ModItem.SCALLOP_MEAT_ITEM.get()), AbysmalDataGen.has(ModItem.SCALLOP_MEAT_ITEM))
            .save(provider, AbysmalDelight.of("campfire_cooking_scallop"));
    }
}
