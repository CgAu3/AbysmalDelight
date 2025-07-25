package io.github.cgau3.abysmaldelight.init;

import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.cgau3.abysmaldelight.item.LaverFilamentItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;
import java.util.Optional;

import static io.github.cgau3.abysmaldelight.AbysmalDelight.A_REGISTRATE;

public class ModItem {

    static {
        A_REGISTRATE.defaultCreativeTab(ModItemGroup.ABYSMAL_TAB.getKey());
    }

    public static ItemEntry<Item> LAVER_ITEM = A_REGISTRATE
        .item("laver", Item::new)
        .tag(ItemTags.TURTLE_FOOD, ModItemTag.LAVER)
        .compostable(0.3f)
        .register();
    public static ItemEntry<Item> NORI_ITEM = A_REGISTRATE
        .item("nori", Item::new)
        .tag(ModItemTag.LAVER)
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(1)                   // 1饱食度
                .saturationModifier(0.6f)       // 0.6饱和度（数值同干海带）
                .fast()
                .build()
            )
        )
        .compostable(0.3f)
        .register();
    public static ItemEntry<DrinkableItem> LAVER_AND_EGG_SOUP_ITEM = A_REGISTRATE
        .item("laver_and_egg_soup", p -> new DrinkableItem(p, true))
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(6)                   // 6饱食度
                .saturationModifier(1f)         // 6饱和度
                .usingConvertsTo(Items.BOWL)
                .effect(() -> FoodValues.comfort(FoodValues.MEDIUM_DURATION), 1.0F)
                .build()
            )
            .craftRemainder(Items.BOWL)
            .stacksTo(16)
        )
        .register();
    public static ItemEntry<Item> LAVER_ROLL_ITEM = A_REGISTRATE
        .item("laver_roll", Item::new)
        .properties(p -> p
            .food(new FoodProperties(
                12,
                12,
                false,
                2.4f,
                Optional.empty(),
                List.of()
            ))
        )
        .compostable(1f)
        .register();
    public static ItemEntry<Item> LAVER_ROLL_SLICE_ITEM = A_REGISTRATE
        .item("laver_roll_slice", Item::new)
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(6)                     // 6饱食度
                .saturationModifier(0.6f)         // 7.2饱和度，数值略高于海带寿司卷
                .fast()
                .build()
            )
        )
        .compostable(0.3f)
        .register();
    public static ItemEntry<LaverFilamentItem> LAVER_FILAMENT_ITEM = A_REGISTRATE
        .item("laver_filament", LaverFilamentItem::new)
        .compostable(0.1f)
        .register();

    public static void register() {}
}
