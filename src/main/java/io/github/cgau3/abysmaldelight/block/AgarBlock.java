package io.github.cgau3.abysmaldelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class AgarBlock extends HalfTransparentBlock{

    public AgarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(
        @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, Entity entity, float fallDistance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(level, state, pos, entity, fallDistance);
        } else {
            entity.causeFallDamage(fallDistance, 0.0F, level.damageSources().fall());
        }
    }

    @Override
    public void updateEntityAfterFallOn(@NotNull BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(level, entity);
        } else {
            Vec3 vec3 = entity.getDeltaMovement();
            if (vec3.y < -entity.getGravity()) {
                double d = entity instanceof LivingEntity ? 1.0 : 0.8;
                entity.setDeltaMovement(vec3.x, -vec3.y * d, vec3.z);
            }
            else if (vec3.y < 0) {
                super.updateEntityAfterFallOn(level, entity);
            }
        }
    }

    @Override
    public boolean isSlimeBlock(BlockState state) {
        return true;
    }
}
