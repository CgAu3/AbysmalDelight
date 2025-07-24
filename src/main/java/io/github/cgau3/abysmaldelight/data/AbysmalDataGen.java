package io.github.cgau3.abysmaldelight.data;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.data.provider.ModLootTableProvider;
import io.github.cgau3.abysmaldelight.data.recipe.RecipeHandler;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.cgau3.abysmaldelight.AbysmalDelight.A_REGISTRATE;

@EventBusSubscriber(modid = AbysmalDelight.MODID)
public class AbysmalDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));
    }

    public static void init() {
        //A_REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, TagsHandler::initItem);
        A_REGISTRATE.addDataGenerator(ProviderType.RECIPE, RecipeHandler::init);
        //A_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
        //也是啥也不做，但是以后会用到的
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        return RegistrateRecipeProvider.has(itemLike);
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return RegistrateRecipeProvider.has(tag);
    }

    public static @NotNull String hasItem(@NotNull TagKey<Item> item) {
        return "has_" + item.location().getPath();
    }

    public static @NotNull String hasItem(@NotNull ItemLike item) {
        return "has_" + BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }
}
