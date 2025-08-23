package io.github.cgau3.abysmaldelight.core.bait;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.cgau3.abysmaldelight.init.ModLootTable;
import lombok.Getter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.loot.LootTable;

@Getter
public class BaitType {

    public static final MapCodec<BaitType> MAP_CODEC = RecordCodecBuilder.mapCodec(ins -> ins.group(
        Codec.FLOAT.fieldOf("consumptionRate").forGetter(BaitType::getConsumptionRate),
        Codec.INT.fieldOf("lureBoost").forGetter(BaitType::getLureBoost),
        Codec.FLOAT.fieldOf("luckBoost").forGetter(BaitType::getLuckBoost),
        ResourceKey.codec(Registries.LOOT_TABLE)
            .fieldOf("fishingLootTable")
            .forGetter(BaitType::getFishingLootTable)
    ).apply(ins, BaitType::new));

    public static final Codec<BaitType> CODEC = MAP_CODEC.codec();

    public final float consumptionRate;
    public final int lureBoost;
    public final float luckBoost;
    public final ResourceKey<LootTable> fishingLootTable;

    public BaitType(
        float consumptionRate,
        int lureBoost,
        float luckBoost,
        ResourceKey<LootTable> fishingLootTable
    ) {
        this.consumptionRate = consumptionRate;
        this.lureBoost = lureBoost;
        this.luckBoost = luckBoost;
        this.fishingLootTable = fishingLootTable;
    }

    public LootTable getLootTable(ServerLevel level) {
        return level.getServer().reloadableRegistries().getLootTable(this.fishingLootTable);
    }

    public static BaitType.Builder builder() {
        return new BaitType.Builder();
    }

    public static class Builder {
        private float consumptionRate = 0.1f;
        private int lureBoost = 0;
        private float luckBoost = 0;
        private ResourceKey<LootTable> fishingLootTable = null;

        public BaitType build() {
            if (this.fishingLootTable == null)
                this.fishingLootTable = ModLootTable.FISHING_BAIT_AVERAGE;
            return new BaitType(
                this.consumptionRate,
                this.lureBoost,
                this.luckBoost,
                this.fishingLootTable
            );
        }

        public Builder lure(int lureBoost) {
            this.lureBoost = lureBoost;
            return this;
        }

        public Builder luck(int luckBoost) {
            this.luckBoost = luckBoost;
            return this;
        }

        public Builder consume(float consumptionRate) {
            this.consumptionRate = consumptionRate;
            return this;
        }

        public Builder loot(ResourceKey<LootTable> fishingLootTable) {
            this.fishingLootTable = fishingLootTable;
            return this;
        }
    }

}

