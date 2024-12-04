package org.flenarn.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.flenarn.NetherAdditions;
import org.flenarn.item.custom.WeepingFishingRodItem;

public class NetherAdditionsItems {

    public static Item WEEPING_FISHING_ROD = registerItem("weeping_fishing_rod", new WeepingFishingRodItem(new Item.Settings().maxDamage(64).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId("weeping_fishing_rod")))));

    public static Item PYROLITHID = registerItem("pyrolithid", new Item(new Item.Settings().food(NetherAdditionsFoodComponents.PYROLITHID, NetherAdditionsConsumableComponents.PYROLIHID).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId("pyrolithid")))));
    public static Item LAVACANTH = registerItem("lavacanth", new Item(new Item.Settings().food(NetherAdditionsFoodComponents.LAVACANTH, NetherAdditionsConsumableComponents.LAVACANTH).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId("lavacanth")))));
    public static Item GOLDHEAD_WRASSE = registerItem("goldhead_wrasse", new Item(new Item.Settings().food(NetherAdditionsFoodComponents.GOLDHEAD_WRASSE).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId("goldhead_wrasse")))));
    public static Item ECTOCARP = registerItem("ectocarp", new Item(new Item.Settings().food(NetherAdditionsFoodComponents.ECTOCARP, NetherAdditionsConsumableComponents.ECTOCARP).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId("ectocarp")))));
    public static Item LITHID_SOUP = registerItem("lithid_soup", new Item(new Item.Settings().food(NetherAdditionsFoodComponents.LITHID_SOUP, NetherAdditionsConsumableComponents.LITHID_SOUP).maxCount(1).useRemainder(Items.BOWL).registryKey(RegistryKey.of(RegistryKeys.ITEM, NetherAdditions.getModId("lithid_soup")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, NetherAdditions.getModId(name), item);
    }

    public static void registerItems() {
        NetherAdditions.LOGGER.info("Registering items for " + NetherAdditions.MOD_ID + ".");
    }
}
