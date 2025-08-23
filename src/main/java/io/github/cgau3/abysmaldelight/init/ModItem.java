package io.github.cgau3.abysmaldelight.init;

import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.cgau3.abysmaldelight.core.bait.BaitType;
import io.github.cgau3.abysmaldelight.item.BaitItem;
import io.github.cgau3.abysmaldelight.item.LaverFilamentItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static io.github.cgau3.abysmaldelight.AbysmalDelight.A_REGISTRATE;

public class ModItem {

    static {
        A_REGISTRATE.defaultCreativeTab(ModItemGroup.ABYSMAL_TAB.getKey());
    }

    public static ItemEntry<ConsumableItem> SILVERFISH_RAW = A_REGISTRATE
        .item("raw_silverfish", p -> new ConsumableItem(p, true))
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(1)                    // 1饱食度
                .saturationModifier(0.6f)        // 1.2饱和度
                .fast()
                .build()
            )
        )
        .register();

    public static ItemEntry<? extends BaitItem> BAIT_AVERAGE = createBaitItem(
        "average",
        () -> ModBaitTypes.AVERAGE
    );

    public static ItemEntry<? extends BaitItem> BAIT_TANGLING = createBaitItem(
        "tangling",
        () -> ModBaitTypes.TANGLING
    );

    public static ItemEntry<? extends BaitItem> BAIT_DELICATE = createBaitItem(
        "delicate",
        () -> ModBaitTypes.DELICATE
    );

    public static ItemEntry<? extends BaitItem> BAIT_VANILLA = createBaitItem(
        "vanilla",
        () -> ModBaitTypes.VANILLA
    );

    public static ItemEntry<? extends BaitItem> BAIT_MAGNETIC = createBaitItem(
        "magnetic",
        () -> ModBaitTypes.MAGNETIC
    );

    public static ItemEntry<? extends BaitItem> BAIT_MASTERY = createBaitItem(
        "mastery",
        () -> ModBaitTypes.MASTERY
    );

    public static ItemEntry<? extends BaitItem> BAIT_DEFAULT = createBaitItem(
        "default",
        () -> ModBaitTypes.DEFAULT
    );

    public static ItemEntry<Item> LAVER_ITEM = A_REGISTRATE
        .item("laver", Item::new)
        .tag(ModItemTag.LAVER, ModItemTag.SEA_TANGLES)
        .compostable(0.3f)
        .register();
    public static ItemEntry<Item> NORI_ITEM = A_REGISTRATE
        .item("nori", Item::new)
        .tag(ModItemTag.LAVER)
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(1)                   // 1饱食度
                .saturationModifier(0.6f)       // 1.2饱和度，略高于干海带
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
                .saturationModifier(1f)         // 12饱和度
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
        .compostable(0.55f)
        .register();
    public static ItemEntry<LaverFilamentItem> LAVER_FILAMENT_ITEM = A_REGISTRATE
        .item("laver_filament", LaverFilamentItem::new)
        .compostable(0.1f)
        .register();

    public static ItemEntry<Item> AGAR_ITEM = A_REGISTRATE
        .item("agar", Item::new)
        .register();

    //这里之后写琼脂拳套。琼脂块和琼脂弹板属于方块而不是物品；不过琼脂弹板需要注册自己的物品类型
    //不过既然紫菜有琼脂拳套了，或许应该考虑给海带做一个对位的海带鞭子

    public static ItemEntry<Item> SCALLOP_ITEM = A_REGISTRATE
        .item("scallop", Item::new)
        .register();
    public static ItemEntry<Item> SHELL_ITEM = A_REGISTRATE
        .item("shell", Item::new)
        .register();
    public static ItemEntry<Item> SCALLOP_MEAT_ITEM = A_REGISTRATE
        .item("scallop_meat", Item::new)
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(2)                     // 2饱食度
                .saturationModifier(0.5f)         // 2饱和度
                .build()
            )
        )
        .register();
    public static ItemEntry<Item> DIRED_SCALLOP_MEAT_ITEM = A_REGISTRATE
        .item("dried_scallop_meat", Item::new)
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(2)                     // 2饱食度
                .saturationModifier(0.75f)        // 3饱和度
                .build()
            )
        )
        .register();
    public static ItemEntry<Item> PEARL_ITEM = A_REGISTRATE
        .item("pearl", Item::new)
        .register();
    public static ItemEntry<ConsumableItem> STEAMED_SCALLOP_ITEM = A_REGISTRATE
        .item("steamed_scallop", p -> new ConsumableItem(p, true))
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(5)                   // 5饱食度
                .saturationModifier(0.8f)       // 8饱和度
                .usingConvertsTo(ModItem.SHELL_ITEM.get())
                .effect(
                    () -> new MobEffectInstance(MobEffects.WATER_BREATHING, FoodValues.MEDIUM_DURATION, 0, false, false),
                    1.0F)
                .build()
            )
            .craftRemainder(ModItem.SHELL_ITEM.get())
            .stacksTo(16)
        )
        .register();
    public static ItemEntry<ConsumableItem> SEAFOOD_PORRIDGE_ITEM = A_REGISTRATE
        .item("seafood_porridge", p -> new ConsumableItem(p, true))
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(12)                   // 12饱食度
                .saturationModifier(0.9f)        // 21.6饱和度
                .usingConvertsTo(Items.BOWL.asItem())
                .effect(() -> FoodValues.comfort(FoodValues.LONG_DURATION),1.0F)
                .build()
            )
            .craftRemainder(Items.BOWL.asItem())
            .stacksTo(16)
        )
        .register();
    public static ItemEntry<ConsumableItem> SCALLOP_DANGENG_ITEM = A_REGISTRATE
        .item("scallop_dangeng", p -> new ConsumableItem(p, true))
        .properties(p -> p
            .food(new FoodProperties.Builder()
                .nutrition(5)                    // 5饱食度
                .saturationModifier(1.2f)        // 12饱和度
                .usingConvertsTo(Items.BOWL.asItem())
                .effect(() -> FoodValues.comfort(FoodValues.SHORT_DURATION),1.0F)
                .build()
            )
            .craftRemainder(Items.BOWL.asItem())
            .stacksTo(16)
        )
        .register();

    //TODO: 重做扇贝、贝壳、蒸扇贝的美术

    private static @NotNull ItemEntry<? extends BaitItem> createBaitItem(
        String type, Supplier<DeferredHolder<BaitType, ?>> typeGetter
    ) {
        return A_REGISTRATE
            .item(type + "_bait", properties -> new BaitItem(properties) {
                @Override
                public Holder<BaitType> getType() {
                    return typeGetter.get();
                }
            })
            .tag(ModItemTag.BAIT)
            .register();
    }

    public static void register() {}
}
