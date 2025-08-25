package io.github.cgau3.abysmaldelight.data.recipe;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.data.AbysmalDataGen;
import io.github.cgau3.abysmaldelight.init.ModItem;
import io.github.cgau3.abysmaldelight.init.ModItemTag;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
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
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.BAIT_VANILLA, 10)
            .pattern("AAA")
            .pattern("ASA")
            .pattern("AAA")
            .define('A', ModItem.BAIT_AVERAGE)
            .define('S', Items.GRASS_BLOCK)
            .unlockedBy(AbysmalDataGen.hasItem(Items.FISHING_ROD), AbysmalDataGen.has(Items.FISHING_ROD))
            .unlockedBy(AbysmalDataGen.hasItem(ModItem.BAIT_AVERAGE), AbysmalDataGen.has(ModItem.BAIT_AVERAGE))
            .save(provider);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.BAIT_MAGNETIC)
            .pattern("BBB")
            .pattern("CAD")
            .define('A', ModItem.BAIT_DELICATE)
            .define('B', Items.IRON_INGOT)
            .define('C', Items.REDSTONE)
            .define('D', Items.BLUE_DYE)
            .unlockedBy("has_item", AbysmalDataGen.has(ModItem.BAIT_DELICATE))
            .save(provider);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.BAIT_MASTERY)
            .pattern("AAA")
            .pattern("ASA")
            .pattern("ABA")
            .define('A', ModItem.BAIT_DELICATE)
            .define('S', Items.NETHER_STAR)
            .define('B', ModItem.SCALLOP_MEAT_ITEM)
            .unlockedBy(AbysmalDataGen.hasItem(ModItem.BAIT_DELICATE), AbysmalDataGen.has(ModItem.BAIT_DELICATE.get()))
            .unlockedBy(AbysmalDataGen.hasItem(Items.NETHER_STAR), AbysmalDataGen.has(Items.NETHER_STAR))
            .save(provider);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItem.BAIT_AVERAGE, 5)
            .requires(ModItems.COOKED_RICE.get())
            .requires(Items.CARROT)
            .requires(Tags.Items.FOODS_BERRY)
            .requires(Items.SEAGRASS)
            .unlockedBy("has_item", AbysmalDataGen.has(Items.FISHING_ROD))
            .save(provider);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItem.BAIT_TANGLING, 5)
            .requires(Items.TRIPWIRE_HOOK)
            .requires(ModItemTag.INK_SAC)
            .requires(ModItemTag.SEA_TANGLES)
            .requires(ModItemTag.SEA_TANGLES)
            .requires(ModItemTag.SEA_TANGLES)
            .unlockedBy("has_item", AbysmalDataGen.has(Items.FISHING_ROD))
            .save(provider);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItem.BAIT_DELICATE, 5)
            .requires(ModItems.COOKED_RICE.get())
            .requires(ModItem.SILVERFISH_RAW, 2)
            .requires(Tags.Items.FOODS_RAW_FISH)
            .requires(Items.SEAGRASS)
            .requires(Items.SUGAR)
            .unlockedBy("has_item", AbysmalDataGen.has(Items.FISHING_ROD))
            .save(provider);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItem.BAIT_DEFAULT, 1)
            .requires(ModItem.BAIT_VANILLA.get())
            .requires(Items.COAL)
            .requires(Items.MAGENTA_DYE)
            .unlockedBy("has_item", AbysmalDataGen.has(ModItem.BAIT_VANILLA))
            .save(provider);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ENDER_PEARL, 2)
            .requires(ModItem.PEARL_ITEM.get(), 2)
            .requires(Items.ENDER_PEARL)
            .unlockedBy("has_item", AbysmalDataGen.has(ModItem.PEARL_ITEM))
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
