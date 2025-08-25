package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class ModItemTag {
    public static final TagKey<Item> LAVER = bindC("laver");
    public static final TagKey<Item> INK_SAC = bindC("ink_sacs");
    public static final TagKey<Item> AGAR = bindC("agar");

    public static final TagKey<Item> BAIT = bind("bait");
    public static final TagKey<Item> SEA_TANGLES = bind("tangles/sea");

    public static final TagKey<Item> STORAGE_BLOCKS_AGAR = bindC("storage_blocks/agar");

    public static @NotNull TagKey<Item> bindC(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", id));
    }

    public static @NotNull TagKey<Item> bind(String id) {
        return TagKey.create(Registries.ITEM, AbysmalDelight.of(id));
    }
}
