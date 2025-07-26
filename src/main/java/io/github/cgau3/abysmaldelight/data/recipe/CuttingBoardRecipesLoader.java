package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.init.ModItem;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingBoardRecipesLoader {
    public static void init(RegistrateRecipeProvider provider) {
        CuttingBoardRecipeBuilder
            .cuttingRecipe(
                Ingredient.of(ModItem.LAVER_ROLL_ITEM.get()),
                Ingredient.of(CommonTags.TOOLS_KNIFE),
                ModItem.LAVER_ROLL_SLICE_ITEM.get(),
                3)
            .build(provider);
        CuttingBoardRecipeBuilder
            .cuttingRecipe(
                Ingredient.of(ModItem.SCALLOP_ITEM.get()),
                Ingredient.of(CommonTags.TOOLS_KNIFE),
                ModItem.SHELL_ITEM.get(),
                2)
            .addResult(ModItem.SCALLOP_MEAT_ITEM.get(), 1)
            .addResultWithChance(ModItem.LAVER_FILAMENT_ITEM.get(), 0.05f, 1)
            .addResultWithChance(ModItem.PEARL_ITEM.get(), 0.05f, 1)
            .build(provider);
    }
}
