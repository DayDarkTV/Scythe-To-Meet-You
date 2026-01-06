package net.betweenlands.scytheto.items;

import net.betweenlands.scytheto.Scytheto;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ScythetoItems {
    public static final List<ScytheItem> SCYTHES = new ArrayList<>();

    public static final ScytheItem DIAMOND_SCYTHE = registerScythe("diamond_scythe", new ScytheItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.7F))));

    public static void init() {}

    public static <T extends Item> T registerItem(String path, T item) {
        return Registry.register(Registries.ITEM, Scytheto.getId(path), item);
    }
    public static ScytheItem registerScythe(String path, ScytheItem scythe) {
        ScytheItem s = registerItem(path, scythe);
        SCYTHES.add(s);
        return s;
    }
}
