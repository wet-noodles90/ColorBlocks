package net.hotdoguy90.colorblocks;

import net.fabricmc.api.ModInitializer;

import net.hotdoguy90.colorblocks.block.ColorBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorBlocks implements ModInitializer {
	public static final String MOD_ID = "colorblocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ColorBlock.registerColorBlock();
	}
}