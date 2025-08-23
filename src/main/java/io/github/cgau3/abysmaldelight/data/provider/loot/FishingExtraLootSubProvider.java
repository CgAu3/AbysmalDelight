package io.github.cgau3.abysmaldelight.data.provider.loot;

import io.github.cgau3.abysmaldelight.init.ModItem;
import io.github.cgau3.abysmaldelight.init.ModLootTable;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = this.provider.lookupOrThrow(Registries.ENCHANTMENT);
        biConsumer.accept(
            ModLootTable.FISHING_BAIT_AVERAGE,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_FISH)
                        .setWeight(50))
                    .add(LootItem.lootTableItem(ModItem.SCALLOP_ITEM.get())
                        .setWeight(10)
                        .setQuality(1))
                    .add(LootItem.lootTableItem(Items.INK_SAC.asItem())
                        .setWeight(5))
                    .add(LootItem.lootTableItem(Items.SEAGRASS.asItem())
                        .setWeight(2))
                    .add(LootItem.lootTableItem(ModItem.LAVER_ITEM.get())
                        .setWeight(15)
                        .setQuality(1)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.NAUTILUS_SHELL.asItem())
                        .setWeight(5)
                        .setQuality(1)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.TROPICAL_FISH.asItem())
                        .setWeight(15)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM)
                            )
                        ))
                    )
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

        biConsumer.accept(
            ModLootTable.FISHING_BAIT_TANGLING,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_JUNK)
                        .setWeight(50)
                        .setQuality(-1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_TREASURE)
                        .setWeight(2)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(Items.SEAGRASS.asItem())
                        .setWeight(10)
                        .setQuality(-1))
                    .add(LootItem.lootTableItem(Items.STRING.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.TRIPWIRE_HOOK.asItem())
                        .setWeight(5))
                    .add(LootItem.lootTableItem(Items.FISHING_ROD.asItem())
                        .setWeight(1)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(20.0F, 30F))))
                    .add(LootItem.lootTableItem(Items.BOW.asItem())
                        .setWeight(1)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(20.0F, 30F))))
                    .add(LootItem.lootTableItem(Items.NAME_TAG.asItem())
                        .setWeight(5)
                        .setQuality(1))
                    .add(LootItem.lootTableItem(ModItem.LAVER_ITEM.get())
                        .setWeight(15)
                        .setQuality(1)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.KELP.asItem())
                        .setWeight(15)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.SEA_PICKLE.asItem())
                        .setWeight(5)
                        .setQuality(1)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM)
                            )
                        ))
                    )
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_CORAL)
                        .setWeight(15)
                        .setQuality(1)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.SCULK_VEIN.asItem())
                        .setWeight(10)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_ANCIENT_CITY)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.BAMBOO.asItem())
                        .setWeight(10)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(Tags.Biomes.IS_JUNGLE)
                            )
                        ))
                    )
                )
        );

        biConsumer.accept(
            ModLootTable.FISHING_BAIT_DELICATE,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_BAIT_AVERAGE)
                        .setWeight(95)
                        .setQuality(-1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_TREASURE)
                        .setWeight(5)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(ModItem.SCALLOP_ITEM.get())
                        .setWeight(2))
                    .add(LootItem.lootTableItem(Items.BOOK)
                        .setWeight(1)
                        .setQuality(3)
                        .apply(
                            EnchantWithLevelsFunction.enchantWithLevels(
                                this.provider, UniformGenerator.between(30.0f, 50.0f)
                            )
                        )
                    )
                    .add(LootItem.lootTableItem(ModItem.LAVER_ITEM.get())
                        .setWeight(2)
                        .setQuality(1)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.BOOK)
                        .setWeight(2)
                        .setQuality(3)
                        .apply(
                            new EnchantRandomlyFunction.Builder()
                                .withEnchantment(
                                    enchantmentRegistryLookup.getOrThrow(Enchantments.SWIFT_SNEAK)
                                )
                        )
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_ANCIENT_CITY)
                            )
                        ))
                    )
                )
        );

        biConsumer.accept(
            ModLootTable.FISHING_BAIT_VANILLA,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_JUNK)
                        .setWeight(10)
                        .setQuality(-2))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_TREASURE)
                        .setWeight(5)
                        .setQuality(2))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_FISH)
                        .setWeight(85)
                        .setQuality(-1))
                )
        );

        biConsumer.accept(
            ModLootTable.FISHING_BAIT_MAGNETIC,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_JUNK)
                        .setWeight(50)
                        .setQuality(-2))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_TREASURE)
                        .setWeight(50)
                        .setQuality(2))
                    //这里之后加个提丰螺
                    //这里之后加个海华金锭
                    .add(LootItem.lootTableItem(Items.TRIPWIRE_HOOK)
                        .setWeight(5))
                    .add(LootItem.lootTableItem(Items.IRON_INGOT)
                        .setWeight(5))
                    .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                        .setWeight(5))
                    .add(LootItem.lootTableItem(Items.COPPER_INGOT)
                        .setWeight(15))
                    .add(LootItem.lootTableItem(Items.IRON_NUGGET)
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.REDSTONE_TORCH)
                        .setWeight(10))
                    .add(LootItem.lootTableItem(ModItem.SCALLOP_ITEM)
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.CROSSBOW)
                        .setWeight(5)
                        .setQuality(1)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                    )
                    .add(LootItem.lootTableItem(Items.CHAINMAIL_BOOTS)
                        .setWeight(5)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                    )
                    .add(LootItem.lootTableItem(Items.CHAINMAIL_HELMET)
                        .setWeight(5)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                    )
                    .add(LootItem.lootTableItem(Items.CHAINMAIL_CHESTPLATE)
                        .setWeight(5)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                    )
                    .add(LootItem.lootTableItem(Items.CHAINMAIL_LEGGINGS)
                        .setWeight(10)
                        .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                        .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                    )
                    .add(LootItem.lootTableItem(Items.BOOK)
                        .setWeight(10)
                        .setQuality(3)
                        .apply(
                            new EnchantRandomlyFunction.Builder()
                                .withEnchantment(
                                    enchantmentRegistryLookup.getOrThrow(Enchantments.SWIFT_SNEAK)
                                )
                        )
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_ANCIENT_CITY)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.BOOK)
                        .setWeight(10)
                        .setQuality(3)
                        .apply(
                            new EnchantRandomlyFunction.Builder()
                                .withEnchantment(
                                    enchantmentRegistryLookup.getOrThrow(Enchantments.MENDING)
                                )
                        )
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_SWAMP_HUT)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.HEART_OF_THE_SEA)
                        .setWeight(1)
                        .setQuality(3)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                )
        );

        biConsumer.accept(
            ModLootTable.FISHING_BAIT_MASTERY,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_BAIT_DELICATE)
                        .setWeight(70)
                        .setQuality(-1))
                    .add(NestedLootTable.lootTableReference(ModLootTable.FISHING_NESTED_VANILLA_TREASURE)
                        .setWeight(50)
                        .setQuality(2))
                    //这里需要更多鱼类
                    //这里需要海华金锭
                    .add(LootItem.lootTableItem(Items.BOOK)
                        .setWeight(10)
                        .setQuality(3)
                        .apply(
                            new EnchantRandomlyFunction.Builder()
                                .withEnchantment(
                                    enchantmentRegistryLookup.getOrThrow(Enchantments.SWIFT_SNEAK)
                                )
                        )
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_ANCIENT_CITY)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.BOOK)
                        .setWeight(10)
                        .setQuality(3)
                        .apply(
                            new EnchantRandomlyFunction.Builder()
                                .withEnchantment(
                                    enchantmentRegistryLookup.getOrThrow(Enchantments.MENDING)
                                )
                        )
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.HAS_SWAMP_HUT)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.HEART_OF_THE_SEA)
                        .setWeight(5)
                        .setQuality(3)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                    .add(LootItem.lootTableItem(Items.SNIFFER_EGG)
                        .setWeight(5)
                        .setQuality(3)
                        .when(LocationCheck.checkLocation(
                            LocationPredicate.Builder.location().setBiomes(
                                biomeRegistryLookup.getOrThrow(BiomeTags.IS_OCEAN)
                            )
                        ))
                    )
                )
        );

        biConsumer.accept(
            ModLootTable.FISHING_NESTED_CORAL,
            LootTable.lootTable()
                .withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(Items.BRAIN_CORAL.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.BUBBLE_CORAL.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.FIRE_CORAL.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.HORN_CORAL.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.TUBE_CORAL.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.BRAIN_CORAL_BLOCK.asItem())
                        .setWeight(5)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(Items.BUBBLE_CORAL_BLOCK.asItem())
                        .setWeight(5)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(Items.FIRE_CORAL_BLOCK.asItem())
                        .setWeight(5)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(Items.HORN_CORAL_BLOCK.asItem())
                        .setWeight(5)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(Items.TUBE_CORAL_BLOCK.asItem())
                        .setWeight(5)
                        .setQuality(2))
                    .add(LootItem.lootTableItem(Items.BRAIN_CORAL_FAN.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.BUBBLE_CORAL_FAN.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.FIRE_CORAL_FAN.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.HORN_CORAL_FAN.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.TUBE_CORAL_FAN.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.TROPICAL_FISH.asItem())
                        .setWeight(10))
                    .add(LootItem.lootTableItem(Items.SEA_PICKLE.asItem())
                        .setWeight(10))
                )
        );

        biConsumer.accept(
            ModLootTable.FISHING_NESTED_VANILLA_FISH,
            LootTable.lootTable()
            .withPool(
                LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.COD).setWeight(60))
                    .add(LootItem.lootTableItem(Items.SALMON).setWeight(25))
                    .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2))
                    .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(13))
            )
        );
        biConsumer.accept(
            ModLootTable.FISHING_NESTED_VANILLA_JUNK,
            LootTable.lootTable()
                .withPool(
                    LootPool.lootPool()
                        .add(LootItem.lootTableItem(Blocks.LILY_PAD).setWeight(17))
                        .add(
                            LootItem.lootTableItem(Items.LEATHER_BOOTS)
                                .setWeight(10)
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.9F)))
                        )
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(10))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(10))
                        .add(LootItem.lootTableItem(Items.POTION).setWeight(10).apply(SetPotionFunction.setPotion(Potions.WATER)))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(5))
                        .add(
                            LootItem.lootTableItem(Items.FISHING_ROD).setWeight(2).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.9F)))
                        )
                        .add(LootItem.lootTableItem(Items.BOWL).setWeight(10))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(5))
                        .add(LootItem.lootTableItem(Items.INK_SAC).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(10.0F))))
                        .add(LootItem.lootTableItem(Blocks.TRIPWIRE_HOOK).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10))
                        .add(
                            LootItem.lootTableItem(Blocks.BAMBOO)
                                .when(
                                    LocationCheck.checkLocation(
                                        LocationPredicate.Builder.location()
                                            .setBiomes(
                                                biomeRegistryLookup.getOrThrow(Tags.Biomes.IS_JUNGLE)
                                            )
                                    )
                                )
                                .setWeight(10)
                        )
                )
        );
        biConsumer.accept(
            ModLootTable.FISHING_NESTED_VANILLA_TREASURE,
            LootTable.lootTable()
                .withPool(
                    LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.NAME_TAG))
                        .add(LootItem.lootTableItem(Items.SADDLE))
                        .add(
                            LootItem.lootTableItem(Items.BOW)
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                                .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                        )
                        .add(
                            LootItem.lootTableItem(Items.FISHING_ROD)
                                .apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.25F)))
                                .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                        )
                        .add(
                            LootItem.lootTableItem(Items.BOOK)
                                .apply(EnchantWithLevelsFunction.enchantWithLevels(provider, ConstantValue.exactly(30.0F)))
                        )
                        .add(LootItem.lootTableItem(Items.NAUTILUS_SHELL))
                )
        );

    }
}
