package net.betweenlands.scytheto.datagen;

import net.betweenlands.scytheto.items.ScythetoItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ScythetoLang extends FabricLanguageProvider {
    protected ScythetoLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder builder) {
        builder.add(ScythetoItems.NETHERITE_SCYTHE, "Netherite Scythe");
        builder.add(ScythetoItems.DIAMOND_SCYTHE, "Diamond Scythe");
        builder.add(ScythetoItems.GOLD_SCYTHE, "Gold Scythe");
        builder.add(ScythetoItems.IRON_SCYTHE, "Iron Scythe");
        builder.add(ScythetoItems.STONE_SCYTHE, "Stone Scythe");
    }
}
