package io.github.cgau3.abysmaldelight.init;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateProvider;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.cgau3.abysmaldelight.block.AgarBlock;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.Tags;

import java.util.Objects;

import static io.github.cgau3.abysmaldelight.AbysmalDelight.A_REGISTRATE;

public class ModBlock {
    static {
        A_REGISTRATE.defaultCreativeTab(Objects.requireNonNull(ModItemGroup.ABYSMAL_TAB.getKey()));
    }

    public static BlockEntry<AgarBlock> AGAR_BLOCK = A_REGISTRATE
        .block("agar_block", AgarBlock::new)
        .initialProperties(() -> Blocks.SLIME_BLOCK)
        .blockstate(ModBlock::noExtraModelOrState)
        .properties(
            properties -> properties
                .sound(SoundType.FUNGUS)
                .friction(0.6f)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .instrument(NoteBlockInstrument.FLUTE)
        )
        .item()
        .tag(Tags.Items.STORAGE_BLOCKS, ModItemTag.STORAGE_BLOCKS_AGAR)
        .build()
        .tag(BlockTags.MUSHROOM_GROW_BLOCK,
            Tags.Blocks.STORAGE_BLOCKS,
            ModBlockTag.STORAGE_BLOCKS_AGAR)
        .recipe((ctx, provider) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ctx.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItemTag.AGAR)
                .unlockedBy("has_item", RegistrateRecipeProvider.has(ModItem.AGAR_ITEM))
                .save(provider);
        })
        .register();

    public static <T extends RegistrateProvider> void noExtraModelOrState(DataGenContext<?, ?> context, T provider) {
    }

    public static void register() {
    }
}
