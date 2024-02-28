package org.flenarn.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;
import org.flenarn.item.custom.WeepingFishingRodItem;

public class NetherAdditionsItems {

    public static Item WEEPING_FISHING_ROD = registerItem("weeping_fishing_rod", new WeepingFishingRodItem(new Item.Settings().maxDamage(64)));

    public static Item CELEOCANTH = registerItem("celeocanth", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NetherAdditions.MOD_ID, name), item);
    }

    public static void registerItems() {
        NetherAdditions.LOGGER.info("Registering items for " + NetherAdditions.MOD_ID + ".");
    }
}
