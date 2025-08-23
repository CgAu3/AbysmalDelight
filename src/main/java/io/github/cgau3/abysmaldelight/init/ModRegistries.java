package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.core.bait.BaitType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = AbysmalDelight.MODID)
public class ModRegistries {

    public static final ResourceKey<Registry<BaitType>> BAIT_TYPE_KEY = ResourceKey.createRegistryKey(
        AbysmalDelight.of("bait_type")
    );
    public static final Registry<BaitType> BAIT_TYPE_REGISTRY = new RegistryBuilder<>(BAIT_TYPE_KEY)
        .maxId(512)
        .create();

    @SubscribeEvent
    public static void registerRegistries(@NotNull NewRegistryEvent event) {
        event.register(BAIT_TYPE_REGISTRY);
    }
}
