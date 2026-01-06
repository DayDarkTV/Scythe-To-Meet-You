package net.betweenlands.scytheto.items;

import net.betweenlands.scytheto.Scytheto;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ScythetoItemTags {
    public static final TagKey<Item> SCYTHES = TagKey.of(RegistryKeys.ITEM, Scytheto.getId("scythes"));
}
