package io.github.cgau3.abysmaldelight.data.tags;

import com.tterrag.registrate.providers.RegistrateTagsProvider;
import io.github.cgau3.abysmaldelight.init.ModItemTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ItemTagLoader {
    private static @NotNull ResourceKey<Item> getResourceKey(Item item) {
        return ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(item));
    }

    public static void init(@NotNull RegistrateTagsProvider<Item> provider) {
        provider.addTag(ModItemTag.INK_SAC)
            .add(getResourceKey(Items.INK_SAC))
            .add(getResourceKey(Items.GLOW_INK_SAC));
        provider.addTag(ModItemTag.SEA_TANGLES)
            .add(getResourceKey(Items.SEAGRASS))
            .add(getResourceKey(Items.KELP));
    }
}
