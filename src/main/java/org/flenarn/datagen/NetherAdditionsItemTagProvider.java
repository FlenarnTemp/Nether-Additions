package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import org.flenarn.item.NetherAdditionsItems;

import java.util.concurrent.CompletableFuture;

public class NetherAdditionsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public NetherAdditionsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(NetherAdditionsItems.GOLDHEAD_WRASSE);

        getOrCreateTagBuilder(ItemTags.FISHES)
                .add(NetherAdditionsItems.GOLDHEAD_WRASSE)
                .add(NetherAdditionsItems.ECTOCARP)
                .add(NetherAdditionsItems.PYROLITHID)
                .add(NetherAdditionsItems.LAVACANTH);
    }
}
