package org.flenarn;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.flenarn.datagen.NetherAdditionsBlockTagProvider;
import org.flenarn.datagen.NetherAdditionsItemTagProvider;
import org.flenarn.datagen.NetherAdditionsModelProvider;
import org.flenarn.datagen.NetherAdditionsRecipeProvider;
import org.flenarn.datagen.NetherAdditionsBlockLootTableProvider;

public class NetherAdditionsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(NetherAdditionsModelProvider::new);
		pack.addProvider(NetherAdditionsRecipeProvider::new);
		pack.addProvider(NetherAdditionsItemTagProvider::new);
		pack.addProvider(NetherAdditionsBlockTagProvider::new);
		pack.addProvider(NetherAdditionsBlockLootTableProvider::new);
	}
}