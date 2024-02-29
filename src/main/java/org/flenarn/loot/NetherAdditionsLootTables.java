package org.flenarn.loot;

import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

public class NetherAdditionsLootTables {

    public static final Identifier LAVA_FISHING = new Identifier(NetherAdditions.MOD_ID, "gameplay/lava_fishing");

    public static void registerLootTables() {
        NetherAdditions.LOGGER.info("Registering loot tables for " + NetherAdditions.MOD_ID + ".");
    }
}
