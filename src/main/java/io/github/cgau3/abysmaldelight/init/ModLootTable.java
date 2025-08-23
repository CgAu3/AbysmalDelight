package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTable {
    public static final ResourceKey<LootTable> FISHING_BAIT_AVERAGE =
        key("gameplay/fishing/bait/average");
    public static final ResourceKey<LootTable> FISHING_BAIT_TANGLING =
        key("gameplay/fishing/bait/tangling");
    public static final ResourceKey<LootTable> FISHING_BAIT_DELICATE =
        key("gameplay/fishing/bait/delicate");
    public static final ResourceKey<LootTable> FISHING_BAIT_VANILLA =
        key("gameplay/fishing/bait/vanilla");
    public static final ResourceKey<LootTable> FISHING_BAIT_MAGNETIC =
        key("gameplay/fishing/bait/magnetic");
    public static final ResourceKey<LootTable> FISHING_BAIT_MASTERY =
        key("gameplay/fishing/bait/mastery");
    public static final ResourceKey<LootTable> FISHING_NESTED_CORAL =
        key("gameplay/fishing/nested/coral");
    public static final ResourceKey<LootTable> FISHING_NESTED_VANILLA_FISH =
        key("gameplay/fishing/nested/vanilla/fish");
    public static final ResourceKey<LootTable> FISHING_NESTED_VANILLA_JUNK =
        key("gameplay/fishing/nested/vanilla/junk");
    public static final ResourceKey<LootTable> FISHING_NESTED_VANILLA_TREASURE =
        key("gameplay/fishing/nested/vanilla/treasure");

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, AbysmalDelight.of(path));
    }

}
