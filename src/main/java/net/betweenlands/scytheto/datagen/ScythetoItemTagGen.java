package net.betweenlands.scytheto.datagen;

import net.betweenlands.scytheto.items.ScythetoItemTags;
import net.betweenlands.scytheto.items.ScythetoItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ScythetoItemTagGen extends FabricTagProvider.ItemTagProvider {

    public ScythetoItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        addAllScythes(this.getOrCreateTagBuilder(ScythetoItemTags.SCYTHES));

        addAllScythes(this.getOrCreateTagBuilder(ConventionalItemTags.TOOLS));
        addAllScythes(this.getOrCreateTagBuilder(ConventionalItemTags.MELEE_WEAPON_TOOLS));

        addAllScythes(this.getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS));
        addAllScythes(this.getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE));
    }

    private FabricTagProvider<Item>.FabricTagBuilder addAllScythes(FabricTagBuilder builder) {
        return builder
                .add(ScythetoItems.STONE_SCYTHE)
                .add(ScythetoItems.IRON_SCYTHE)
                .add(ScythetoItems.GOLD_SCYTHE)
                .add(ScythetoItems.DIAMOND_SCYTHE)
                .add(ScythetoItems.NETHERITE_SCYTHE);
    }
}
