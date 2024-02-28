package org.flenarn.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

import static org.flenarn.item.NetherAdditionsItems.*;

public class NetherAdditionsItemGroups {

    public static final ItemGroup NETHER_UPGRADED_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(NetherAdditions.MOD_ID, "nether_upgraded"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.NetherUpgraded"))
                    .icon(() -> new ItemStack(Items.ACACIA_BOAT)).entries((displayContext, entries) -> {
                        entries.add(WEEPING_FISHING_ROD);
                        entries.add(CELEOCANTH);
                    }).build());

    public static void registerItemGroups() {
        NetherAdditions.LOGGER.info("Registering item groups for " + NetherAdditions.MOD_ID + ".");
    }
}
