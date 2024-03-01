package org.flenarn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.block.NetherAdditionsBlocks;
import org.flenarn.entity.effect.NetherAdditionsStatusEffects;
import org.flenarn.entity.projectile.custom.WeepingFishingBobberEntity;
import org.flenarn.item.NetherAdditionsItemGroups;
import org.flenarn.item.NetherAdditionsItems;
import org.flenarn.item.NetherAdditionsPotions;
import org.flenarn.loot.NetherAdditionsLootTables;
import org.flenarn.particle.NetherAdditionsParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherAdditions implements ModInitializer {
	public static final String MOD_ID = "nether_additions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		NetherAdditionsItems.registerItems();
		NetherAdditionsBlocks.registerBlocks();
		NetherAdditionsItemGroups.registerItemGroups();
		NetherAdditionsParticles.registerParticles();
		NetherAdditionsPotions.registerPotions();
		NetherAdditionsPotions.registerPotionsRecipes();
		NetherAdditionsLootTables.registerLootTables();
		NetherAdditionsStatusEffects.registeringStatusEffects();
	}
}