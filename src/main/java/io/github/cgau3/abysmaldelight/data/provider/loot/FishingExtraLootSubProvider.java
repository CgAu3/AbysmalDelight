package io.github.cgau3.abysmaldelight.data.provider.loot;

import io.github.cgau3.abysmaldelight.init.ModItem;
import io.github.cgau3.abysmaldelight.init.ModLootTable;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class FishingExtraLootSubProvider implements LootTableSubProvider {
    private final HolderLookup.Provider provider;
    public FishingExtraLootSubProvider(HolderLookup.Provider provider) {
        this.provider = provider;
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        HolderLookup.RegistryLookup<Biome> biomeRegistryLookup = this.provider.lookupOrThrow(Registries.BIOME);
        biConsumer.accept(
            ModLootTable.FISHING_EXTRA,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(ModItem.LAVER_ITEM.get())
                        .setWeight(10)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.TURTLE_SCUTE.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.GLOW_INK_SAC.asItem())
                        .setWeight(10)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(Tags.Biomes.IS_CAVE)
                            )
                        ))
                    )
                )
        );
    }
}
