package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

import static io.github.cgau3.abysmaldelight.AbysmalDelight.A_REGISTRATE;

public class ModItemGroup {
    private static final DeferredRegister<CreativeModeTab> ABYSMAL_TABS_REGISTRY =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AbysmalDelight.MODID);

    static DeferredHolder<CreativeModeTab, ? extends CreativeModeTab> FDTab =
            ModCreativeTabs.CREATIVE_TABS.getEntries().stream().findFirst().orElse(null);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ABYSMAL_TAB =
        ABYSMAL_TABS_REGISTRY.register("block", () -> CreativeModeTab.builder()
            .icon(() -> ModItem.LAVER_ROLL_ITEM.asStack())
            .title(A_REGISTRATE.addLang("itemGroup", AbysmalDelight.of("main"), "Abysmal Delight"))
            .withTabsBefore(
                (FDTab == null || FDTab.getKey() == null) ?
                    CreativeModeTabs.FOOD_AND_DRINKS.registryKey().location() :
                    FDTab.getKey().location()
            )
            .build());
    public static void register(IEventBus modEventBus) {
        ABYSMAL_TABS_REGISTRY.register(modEventBus);
    }
}
