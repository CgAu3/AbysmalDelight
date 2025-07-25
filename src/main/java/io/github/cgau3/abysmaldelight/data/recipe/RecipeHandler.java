package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;

public class RecipeHandler {
    public static void init(RegistrateRecipeProvider provider) {
        VanillaRecipesLoader.init(provider);
        CookingRecipesLoader.init(provider);
        CuttingBoardRecipesLoader.init(provider);
    }
}
