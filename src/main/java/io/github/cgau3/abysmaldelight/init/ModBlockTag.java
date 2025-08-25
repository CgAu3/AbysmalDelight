package io.github.cgau3.abysmaldelight.init;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTag {

    public static final TagKey<Block> STORAGE_BLOCKS_AGAR = bindC("storage_blocks/agar");

    private static TagKey<Block> bindC(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", id));
    }

    private static TagKey<Block> bind(String id) {
        return TagKey.create(Registries.BLOCK, AbysmalDelight.of(id));
    }

}
