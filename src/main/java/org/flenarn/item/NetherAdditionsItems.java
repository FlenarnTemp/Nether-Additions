package org.flenarn.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;
import org.flenarn.item.custom.WeepingFishingRodItem;

public class NetherAdditionsItems {

    public static Item WEEPING_FISHING_ROD = registerItem("weeping_fishing_rod", new WeepingFishingRodItem(new Item.Settings().maxDamage(64)));

    public static Item PYROLITHID = registerItem("pyrolithid", new Item(new FabricItemSettings().food(NetherAdditionsFoodComponents.PYROLITHID)));
    public static Item LAVACANTH = registerItem("lavacanth", new Item(new FabricItemSettings().food(NetherAdditionsFoodComponents.LAVACANTH)));
    public static Item GOLDHEAD_WRASSE = registerItem("goldhead_wrasse", new Item(new FabricItemSettings().food(NetherAdditionsFoodComponents.GOLDHEAD_WRASSE)));
    public static Item ECTOCARP = registerItem("ectocarp", new Item(new FabricItemSettings().food(NetherAdditionsFoodComponents.ECTOCARP)));
    public static Item LITHID_SOUP = registerItem("lithid_soup", new StewItem(new FabricItemSettings().food(NetherAdditionsFoodComponents.LITHID_SOUP).maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NetherAdditions.MOD_ID, name), item);
    }

    public static void registerItems() {
        NetherAdditions.LOGGER.info("Registering items for " + NetherAdditions.MOD_ID + ".");
    }
}
