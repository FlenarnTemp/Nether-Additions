package org.flenarn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.entity.projectile.WeepingFishingBobberEntity;
import org.flenarn.item.NetherAdditionsItemGroups;
import org.flenarn.item.NetherAdditionsItems;
import org.flenarn.item.NetherAdditionsPotions;
import org.flenarn.particle.NetherAdditionsParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherAdditions implements ModInitializer {
	public static final String MOD_ID = "nether_additions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<WeepingFishingBobberEntity> WEEPING_FISHING_BOBBER_ENTITY_TYPE;

	static {
		WEEPING_FISHING_BOBBER_ENTITY_TYPE = Registry.register(
				Registries.ENTITY_TYPE,
				new Identifier(NetherAdditions.MOD_ID, "weeping_fishing_bobber"),
				FabricEntityTypeBuilder.<WeepingFishingBobberEntity>create(SpawnGroup.MISC, WeepingFishingBobberEntity::new).disableSaving().disableSummon().dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build()
		);
	}


	@Override
	public void onInitialize() {
		NetherAdditionsItemGroups.registerItemGroups();
		NetherAdditionsItems.registerItems();
		NetherAdditionsParticles.registerParticles();
		NetherAdditionsPotions.registerPotions();
		NetherAdditionsPotions.registerPotionsRecipes();}
}