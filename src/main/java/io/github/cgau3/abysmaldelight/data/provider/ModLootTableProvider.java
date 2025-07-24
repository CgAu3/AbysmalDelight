package io.github.cgau3.abysmaldelight.data.provider;

import io.github.cgau3.abysmaldelight.data.provider.loot.FishingExtraLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(
            output,
            Set.of(),
            List.of(
                new SubProviderEntry(FishingExtraLootSubProvider::new, LootContextParamSets.FISHING)
            ),
            provider);
    }
}