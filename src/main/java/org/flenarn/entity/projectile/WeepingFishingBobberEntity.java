//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.flenarn.entity.projectile;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.flenarn.NetherAdditions;
import org.flenarn.item.NetherAdditionsItems;

import java.util.Collections;
import java.util.List;

public class WeepingFishingBobberEntity extends FishingBobberEntity {

    public WeepingFishingBobberEntity(EntityType<? extends FishingBobberEntity> type, World world, int luckOfTheSeaLevel, int lureLevel) {
        super(type, world, luckOfTheSeaLevel, lureLevel);
    }

    public WeepingFishingBobberEntity(PlayerEntity thrower, World world, int luckOfTheSeaLevel, int lureLevel) {
        this(NetherAdditions.WEEPING_FISHING_BOBBER_ENTITY_TYPE, world, luckOfTheSeaLevel, lureLevel);
        this.setOwner(thrower);
        float thrownPitch = thrower.getPitch();
        float thrownYaw = thrower.getYaw();
        float h = MathHelper.cos(-thrownYaw * 0.017453292F - 3.1415927F);
        float i = MathHelper.sin(-thrownYaw * 0.017453292F - 3.1415927F);
        float j = -MathHelper.cos(-thrownPitch * 0.017453292F);
        float k = MathHelper.sin(-thrownPitch * 0.017453292F);
        double throwerX = thrower.getX() - (double)i * 0.3;
        double throwerZ = thrower.getZ() - (double)h * 0.3;
        double throwerEyeY = thrower.getEyeY();
        this.refreshPositionAndAngles(throwerX, throwerEyeY, throwerZ, thrownYaw, thrownPitch);
        Vec3d vec3d = new Vec3d(-i, MathHelper.clamp(-(k / j), -5.0F, 5.0F), -h);
        double m = vec3d.length();
        vec3d = vec3d.multiply(0.6 / m + this.random.nextTriangular(0.5, 0.0103365), 0.6 / m + this.random.nextTriangular(0.5, 0.0103365), 0.6 / m + this.random.nextTriangular(0.5, 0.0103365));
        this.setVelocity(vec3d);
        this.setYaw((float)(MathHelper.atan2(vec3d.x, vec3d.z) * 57.2957763671875));
        this.setPitch((float)(MathHelper.atan2(vec3d.y, vec3d.horizontalLength()) * 57.2957763671875));
        this.prevYaw = this.getYaw();
        this.prevPitch = this.getPitch();
    }

    public WeepingFishingBobberEntity(EntityType<? extends FishingBobberEntity> entityEntityType, World world) {
        super(entityEntityType, world);
    }

    @Override
    public void tick() {
        this.velocityRandom.setSeed(this.getUuid().getLeastSignificantBits() ^ this.getWorld().getTime());
        PlayerEntity playerEntity = this.getPlayerOwner();
        if (playerEntity == null) {
            this.discard();
        } else if (this.getWorld().isClient || !this.removeIfInvalid(playerEntity)) {
            if (this.isOnGround()) {
                ++this.removalTimer;
                if (this.removalTimer >= 1200) {
                    this.discard();
                    return;
                }
            } else {
                this.removalTimer = 0;
            }

            float fluidHeight = 0.0F;
            BlockPos blockPos = this.getBlockPos();
            FluidState fluidState = this.getWorld().getFluidState(blockPos);
            if (fluidState.isIn(FluidTags.LAVA)) {
                fluidHeight = fluidState.getHeight(this.getWorld(), blockPos);
            }

            boolean fluidHeightAboveZero = fluidHeight > 0.0F;
            if (this.state == FishingBobberEntity.State.FLYING) {
                if (this.hookedEntity != null) {
                    this.setVelocity(Vec3d.ZERO);
                    this.state = FishingBobberEntity.State.HOOKED_IN_ENTITY;
                    return;
                }

                if (fluidHeightAboveZero) {
                    this.setVelocity(this.getVelocity().multiply(0.3, 0.2, 0.3));
                    this.state = FishingBobberEntity.State.BOBBING;
                    return;
                }

                this.checkForCollision();
            } else {
                if (this.state == FishingBobberEntity.State.HOOKED_IN_ENTITY) {
                    if (this.hookedEntity != null) {
                        if (!this.hookedEntity.isRemoved() && this.hookedEntity.getWorld().getRegistryKey() == this.getWorld().getRegistryKey()) {
                            this.setPosition(this.hookedEntity.getX(), this.hookedEntity.getBodyY(0.8), this.hookedEntity.getZ());
                        } else {
                            this.updateHookedEntityId(null);
                            this.state = FishingBobberEntity.State.FLYING;
                        }
                    }
                    return;
                }

                if (this.state == FishingBobberEntity.State.BOBBING) {
                    Vec3d vec3d = this.getVelocity();
                    double d = this.getY() + vec3d.y - (double)blockPos.getY() - (double) fluidHeight;
                    if (Math.abs(d) < 0.01) {
                        d += Math.signum(d) * 0.1;
                    }

                    this.setVelocity(vec3d.x * 0.9, vec3d.y - d * (double)this.random.nextFloat() * 0.2, vec3d.z * 0.9);
                    if (this.hookCountdown <= 0 && this.fishTravelCountdown <= 0) {
                        this.inOpenWater = true;
                    } else {
                        this.inOpenWater = this.inOpenWater && this.outOfOpenWaterTicks < 10 && this.isOpenOrLavaAround(blockPos);
                    }

                    if (fluidHeightAboveZero) {
                        this.outOfOpenWaterTicks = Math.max(0, this.outOfOpenWaterTicks - 1);
                        if (this.caughtFish) {
                            this.setVelocity(this.getVelocity().add(0.0, -0.1 * (double)this.velocityRandom.nextFloat() * (double)this.velocityRandom.nextFloat(), 0.0));
                        }

                        if (!this.getWorld().isClient) {
                            this.tickFishingLogic(blockPos);
                        }
                    } else {
                        this.outOfOpenWaterTicks = Math.min(10, this.outOfOpenWaterTicks + 1);
                    }
                }
            }

            if (!fluidState.isIn(FluidTags.LAVA)) {
                this.setVelocity(this.getVelocity().add(0.0, -0.03, 0.0));
            }

            this.move(MovementType.SELF, this.getVelocity());
            this.updateRotation();
            if (this.state == FishingBobberEntity.State.FLYING && (this.isOnGround() || this.horizontalCollision)) {
                this.setVelocity(Vec3d.ZERO);
            }

            this.setVelocity(this.getVelocity().multiply(0.92));
            this.refreshPosition();
        }
    }

    private boolean removeIfInvalid(PlayerEntity player) {
        ItemStack mainHandStack = player.getMainHandStack();
        ItemStack offHandStack = player.getOffHandStack();
        boolean mainHandRod = mainHandStack.isOf(NetherAdditionsItems.WEEPING_FISHING_ROD);
        boolean offHandRod = offHandStack.isOf(NetherAdditionsItems.WEEPING_FISHING_ROD);
        if (!player.isRemoved() && player.isAlive() && (mainHandRod || offHandRod) && !(this.squaredDistanceTo(player) > 1024.0)) {
            return false;
        } else {
            this.discard();
            return true;
        }
    }

    @Override
    public int use(ItemStack usedItem) {
        PlayerEntity playerEntity = this.getPlayerOwner();
        if (!this.getWorld().isClient && playerEntity != null && !this.removeIfInvalid(playerEntity)) {
            int i = 0;
            if (this.hookedEntity != null) {
                this.pullHookedEntity(this.hookedEntity);
                Criteria.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerEntity, usedItem, this, Collections.emptyList());
                this.getWorld().sendEntityStatus(this, (byte)31);
                i = this.hookedEntity instanceof ItemEntity ? 3 : 5;
            } else if (this.hookCountdown > 0) {
                LootContextParameterSet lootContextParameterSet = (new LootContextParameterSet.Builder((ServerWorld)this.getWorld())).add(LootContextParameters.ORIGIN, this.getPos()).add(LootContextParameters.TOOL, usedItem).add(LootContextParameters.THIS_ENTITY, this).luck((float)this.luckOfTheSeaLevel + playerEntity.getLuck()).build(LootContextTypes.FISHING);
                LootTable lootTable = this.getWorld().getServer().getLootManager().getLootTable(LootTables.FISHING_GAMEPLAY);
                List<ItemStack> list = lootTable.generateLoot(lootContextParameterSet);
                Criteria.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerEntity, usedItem, this, list);

                for (ItemStack itemStack : list) {
                    ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), itemStack);
                    double d = playerEntity.getX() - this.getX();
                    double e = playerEntity.getY() - this.getY();
                    double f = playerEntity.getZ() - this.getZ();
                    itemEntity.setVelocity(d * 0.1, e * 0.1 + Math.sqrt(Math.sqrt(d * d + e * e + f * f)) * 0.08, f * 0.1);
                    this.getWorld().spawnEntity(itemEntity);
                    playerEntity.getWorld().spawnEntity(new ExperienceOrbEntity(playerEntity.getWorld(), playerEntity.getX(), playerEntity.getY() + 0.5, playerEntity.getZ() + 0.5, this.random.nextInt(6) + 1));
                    if (itemStack.isIn(ItemTags.FISHES)) {
                        playerEntity.increaseStat(Stats.FISH_CAUGHT, 1);
                    }
                }

                i = 1;
            }

            if (this.isOnGround()) {
                i = 2;
            }

            this.discard();
            return i;
        } else {
            return 0;
        }
    }

    public boolean isOpenOrLavaAround(BlockPos pos) {
        PositionType positionType = FishingBobberEntity.PositionType.INVALID;

        for(int i = -1; i <= 2; ++i) {
            PositionType positionType2 = this.getPositionType(pos.add(-2, i, -2), pos.add(2, i, 2));
            switch (positionType2) {
                case INVALID -> {
                    return false;
                }
                case ABOVE_WATER -> {
                    if (positionType == PositionType.INVALID) {
                        return false;
                    }
                }
                case INSIDE_WATER -> {
                    if (positionType == PositionType.ABOVE_WATER) {
                        return false;
                    }
                }
            }

            positionType = positionType2;
        }

        return true;
    }

    private PositionType getPositionType(BlockPos start, BlockPos end) {
        return BlockPos.stream(start, end).map(this::getPositionType).reduce((positionType, positionType2) -> positionType == positionType2 ? positionType : PositionType.INVALID).orElse(PositionType.INVALID);
    }

    private PositionType getPositionType(BlockPos pos) {
        BlockState blockState = this.getWorld().getBlockState(pos);
        if (!blockState.isAir()) {
            FluidState fluidState = blockState.getFluidState();
            return fluidState.isIn(FluidTags.LAVA) && fluidState.isStill() && blockState.getCollisionShape(this.getWorld(), pos).isEmpty() ? FishingBobberEntity.PositionType.INSIDE_WATER : FishingBobberEntity.PositionType.INVALID;
        } else {
            return FishingBobberEntity.PositionType.ABOVE_WATER;
        }
    }
}
