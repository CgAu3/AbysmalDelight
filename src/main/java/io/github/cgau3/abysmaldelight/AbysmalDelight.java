package io.github.cgau3.abysmaldelight;

import com.tterrag.registrate.Registrate;
import io.github.cgau3.abysmaldelight.data.AbysmalDataGen;
import io.github.cgau3.abysmaldelight.init.ModItem;
import io.github.cgau3.abysmaldelight.init.ModItemGroup;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AbysmalDelight.MODID)
public class AbysmalDelight {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "abysmaldelight";
    public static final String MOD_NAME = "Abysmal Delight";
    public static IEventBus MOD_BUS = null;
    public static final Registrate A_REGISTRATE = Registrate.create(MODID);
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public AbysmalDelight(IEventBus modEventBus) {
        MOD_BUS = modEventBus;
        ModItemGroup.register(modEventBus);
        //ModBlocks.register();
        ModItem.register();
        //ModBlockEntities.register();
        //ModRecipeTypes.register(modEventBus);
        //ModFluids.register(modEventBus);
        //ModEntities.register();

        // datagen
        AbysmalDataGen.init();

        registerEvents(modEventBus);
        LOGGER.info("What is a man? A secret makes a woman woman.");
    }

    private static void registerEvents(@NotNull IEventBus eventBus) {
        eventBus.addListener(AbysmalDelight::loadComplete);
    }

    public static @NotNull ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static void loadComplete(@NotNull FMLLoadCompleteEvent event) {

    }
}
