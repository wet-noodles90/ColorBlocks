package net.hotdoguy90.colorblocks.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hotdoguy90.colorblocks.ColorBlocks;
import net.hotdoguy90.colorblocks.block.custom.ColorBlockBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ColorBlock {

    public static final Block COLOR_BLOCK = registerBlock("color_block", new ColorBlockBehavior(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).mapColor(MapColor.BLACK).luminance(15).strength(0.6F)));
    public static final Item COLOR_BLOCK_ITEM = registerBlockItem("color_block", COLOR_BLOCK);

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ColorBlocks.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ColorBlocks.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void addBlockToRedstone(FabricItemGroupEntries entries) {
        entries.add(COLOR_BLOCK_ITEM);
    }

    public static void registerColorBlock() {
        ColorBlocks.LOGGER.info("Initializing Color Blocks...");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ColorBlock::addBlockToRedstone);
    }
}
