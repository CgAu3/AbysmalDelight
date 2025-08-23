package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.core.bait.BaitType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBaitTypes {
    private static final DeferredRegister<BaitType> REGISTER =
        DeferredRegister.create(ModRegistries.BAIT_TYPE_KEY, AbysmalDelight.MODID);

    private static DeferredHolder<BaitType, ? extends BaitType> register(String typeId, Function<String, BaitType.Builder> builder) {
        return REGISTER.register(typeId, builder.apply(typeId)::build);
    }

    public static final DeferredHolder<BaitType, ? extends BaitType> AVERAGE = register(
        "average",
        type -> BaitType.builder()
            .consume(0.15f)
            .loot(ModLootTable.FISHING_BAIT_AVERAGE)
    );
    public static final DeferredHolder<BaitType, ? extends BaitType> TANGLING = register(
        "tangling",
        type -> BaitType.builder()
            .consume(0.1f)
            .loot(ModLootTable.FISHING_BAIT_TANGLING)
    );
    public static final DeferredHolder<BaitType, ? extends BaitType> DELICATE = register(
        "delicate",
        type -> BaitType.builder()
            .consume(0.05f)
            .lure(5)
            .loot(ModLootTable.FISHING_BAIT_DELICATE)
    );
    public static final DeferredHolder<BaitType, ? extends BaitType> VANILLA = register(
        "vanilla",
        type -> BaitType.builder()
            .consume(0.05f)
            .lure(5)
            .loot(ModLootTable.FISHING_BAIT_VANILLA)
    );
    public static final DeferredHolder<BaitType, ? extends BaitType> DEFAULT = register(
        "default",
        type -> BaitType.builder()
            .consume(0f)
            .loot(ModLootTable.FISHING_BAIT_VANILLA)
    );
    public static final DeferredHolder<BaitType, ? extends BaitType> MAGNETIC = register(
        "magnetic",
        type -> BaitType.builder()
            .consume(0f)
            .lure(5)
            .luck(2)
            .loot(ModLootTable.FISHING_BAIT_MAGNETIC)
    );
    public static final DeferredHolder<BaitType, ? extends BaitType> MASTERY = register(
        "mastery",
        type -> BaitType.builder()
            .consume(0f)
            .lure(25)
            .luck(1)
            .loot(ModLootTable.FISHING_BAIT_MASTERY)
    );

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
