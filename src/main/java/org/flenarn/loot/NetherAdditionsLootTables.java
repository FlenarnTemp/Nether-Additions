package org.flenarn.loot;

import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.flenarn.NetherAdditions;

import java.util.HashSet;
import java.util.Set;

public class NetherAdditionsLootTables {

    private static final Set<RegistryKey<LootTable>> LOOT_TABLES = new HashSet();

    public static final RegistryKey<LootTable> LAVA_FISHING_GAMEPLAY;


    private static RegistryKey<LootTable> register(String id) {
        return registerLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, NetherAdditions.getModId(id)));
    }

    private static RegistryKey<LootTable> registerLootTable(RegistryKey<LootTable> key) {
        if (LOOT_TABLES.add(key)) {
            return key;
        } else {
            throw new IllegalArgumentException(key.getValue() + " is already a registered built-in loot table");
        }
    }


    static {
        LAVA_FISHING_GAMEPLAY = register("gameplay/lava_fishing");
    }

    public static void registerLootTables() {
        NetherAdditions.LOGGER.info("Registering loot tables for " + NetherAdditions.MOD_ID + ".");
    }
}
