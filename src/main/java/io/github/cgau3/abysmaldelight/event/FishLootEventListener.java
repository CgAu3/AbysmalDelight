package io.github.cgau3.abysmaldelight.event;

import io.github.cgau3.abysmaldelight.AbysmalDelight;
import io.github.cgau3.abysmaldelight.init.ModLootTable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;

import java.util.List;

@EventBusSubscriber(modid = AbysmalDelight.MODID)
public class FishLootEventListener {
    @SubscribeEvent
    public static void ApplyExtraFishLoot(ItemFishedEvent event){
        Level level = event.getEntity().level();
        if (level.isClientSide()) return;
        LootTable loot = ModLootTable.getExtraFishing(level);
        ItemStack stack = event.getHookEntity().getWeaponItem();
        stack = stack == null ? Items.AIR.getDefaultInstance() : stack;

        Player player = event.getEntity();
        FishingHook hook = event.getHookEntity();

        LootParams lootparams = new LootParams.Builder((ServerLevel)level)
            .withParameter(LootContextParams.ORIGIN, hook.position())
            .withParameter(LootContextParams.TOOL, stack)
            .withParameter(LootContextParams.THIS_ENTITY, hook)
            .withParameter(LootContextParams.ATTACKING_ENTITY, player)
            .withLuck((float)hook.luck + player.getLuck())
            .create(LootContextParamSets.FISHING);
        List<ItemStack> result = loot.getRandomItems(lootparams);
        float dice = level.getRandom().nextFloat();
        if (!result.isEmpty() && dice <= 0.09f * result.size()) {
            event.setCanceled(true);

            //Replace canceled code
            CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer)player, stack, hook, result);
            for (ItemStack itemstack : result) {
                ItemEntity itementity = new ItemEntity(
                    hook.level(), hook.getX(), hook.getY(), hook.getZ(), itemstack);
                double d0 = player.getX() - hook.getX();
                double d1 = player.getY() - hook.getY();
                double d2 = player.getZ() - hook.getZ();
                itementity.setDeltaMovement(
                    d0 * 0.1,
                    d1 * 0.1 + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08,
                    d2 * 0.1);
                hook.level().addFreshEntity(itementity);
                player.level().addFreshEntity(
                    new ExperienceOrb(
                        player.level(),
                        player.getX(),
                        player.getY() + 0.5,
                        player.getZ() + 0.5,
                        hook.getRandom().nextInt(6) + 1
                    )
                );
                if (itemstack.is(ItemTags.FISHES)) {
                    player.awardStat(Stats.FISH_CAUGHT, 1);
                }
            }
            hook.discard();
            //end replacement
        }
    }
}
