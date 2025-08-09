package org.flenarn;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.flenarn.block.NetherAdditionsBlocks;
import org.flenarn.entity.effect.NetherAdditionsStatusEffects;
import org.flenarn.entity.projectile.NetherAdditionsEntityTypes;
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
		NetherAdditionsPotions.registerPotionRecipes();
		NetherAdditionsLootTables.registerLootTables();
		NetherAdditionsStatusEffects.registeringStatusEffects();
		NetherAdditionsEntityTypes.registerEntities();
	}

	public static Identifier getModId(String id){
		return Identifier.of(MOD_ID, id);
	}
}