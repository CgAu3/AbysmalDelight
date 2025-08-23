package io.github.cgau3.abysmaldelight.item;

import io.github.cgau3.abysmaldelight.core.bait.BaitType;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public abstract class BaitItem extends Item {
    public BaitItem(Properties properties) {
        super(properties);
    }

    public abstract Holder<BaitType> getType();

    //TODO: 给鱼饵加入游戏内说明
}
