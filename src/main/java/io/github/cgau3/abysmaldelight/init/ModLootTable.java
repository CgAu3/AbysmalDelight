package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTable {
    public static final ResourceKey<LootTable> FISHING_EXTRA = key("gameplay/fishing/extra");

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, AbysmalDelight.of(path));
    }

    public static LootTable getExtraFishing(Level level) {
        MinecraftServer server = level.getServer();
        if (server == null) return LootTable.EMPTY;
        return server.reloadableRegistries().getLootTable(FISHING_EXTRA);
    }
}
