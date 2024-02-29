package org.flenarn.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

import static org.flenarn.item.NetherAdditionsItems.*;

public class NetherAdditionsItemGroups {

    public static final ItemGroup NETHER_ADDITONS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(NetherAdditions.MOD_ID, "nether_additions"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.NetherAdditions"))
                    .icon(() -> new ItemStack(PYROLITHID)).entries((displayContext, entries) -> {
                        entries.add(WEEPING_FISHING_ROD);
                        entries.add(LAVACANTH);
                        entries.add(ECTOCARP);
                        entries.add(PYROLITHID);
                        entries.add(GOLDHEAD_WRASSE);
                        entries.add(LITHID_SOUP);
                    }).build());

    public static void registerItemGroups() {
        NetherAdditions.LOGGER.info("Registering item groups for " + NetherAdditions.MOD_ID + ".");
    }
}
