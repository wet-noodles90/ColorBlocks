package net.hotdoguy90.colorblocks;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hotdoguy90.colorblocks.datagen.LootTableProvider;
import net.hotdoguy90.colorblocks.datagen.RecipeProvider;

public class ColorBlocksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RecipeProvider::new);
		pack.addProvider(LootTableProvider::new);
	}
}
