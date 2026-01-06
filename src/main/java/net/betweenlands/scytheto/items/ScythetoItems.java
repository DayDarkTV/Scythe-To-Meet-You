package net.betweenlands.scytheto.items;

import net.betweenlands.scytheto.Scytheto;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ScythetoItems {
    public static final List<ScytheItem> SCYTHES = new ArrayList<>();

    public static final ScytheItem STONE_SCYTHE = registerScythe("stone_scythe", new ScytheItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.STONE, 4, -2.7F))));
    public static final ScytheItem IRON_SCYTHE = registerScythe("iron_scythe", new ScytheItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.IRON, 4, -2.7F))));
    public static final ScytheItem GOLD_SCYTHE = registerScythe("gold_scythe", new ScytheItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.GOLD, 4, -2.7F))));
    public static final ScytheItem DIAMOND_SCYTHE = registerScythe("diamond_scythe", new ScytheItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.7F))));
    public static final ScytheItem NETHERITE_SCYTHE = registerScythe("netherite_scythe", new ScytheItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(ScytheItem.createAttributeModifiers(ToolMaterials.NETHERITE, 4, -2.7F))));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(itemGroup -> SCYTHES.forEach(itemGroup::add));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(itemGroup -> SCYTHES.forEach(itemGroup::add));
    }

    public static <T extends Item> T registerItem(String path, T item) {
        return Registry.register(Registries.ITEM, Scytheto.getId(path), item);
    }
    public static ScytheItem registerScythe(String path, ScytheItem scythe) {
        ScytheItem s = registerItem(path, scythe);
        SCYTHES.add(s);
        return s;
    }
}
