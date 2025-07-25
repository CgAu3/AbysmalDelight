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
    }
}
