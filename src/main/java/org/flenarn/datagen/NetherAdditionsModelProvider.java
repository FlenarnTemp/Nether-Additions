package org.flenarn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import static org.flenarn.item.NetherAdditionsItems.*;

public class NetherAdditionsModelProvider extends FabricModelProvider {
    public NetherAdditionsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Item[] itemsToRegisterGeneratedModel = {
                LAVACANTH,
                PYROLITHID,
                ECTOCARP,
                GOLDHEAD_WRASSE,
                LITHID_SOUP
        };

        for (Item item : itemsToRegisterGeneratedModel) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
