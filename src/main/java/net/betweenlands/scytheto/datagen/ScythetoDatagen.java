package net.betweenlands.scytheto.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ScythetoDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ScythetoModels::new);
        pack.addProvider(ScythetoLang::new);
        pack.addProvider(ScythetoItemTagGen::new);
        pack.addProvider(ScythetoRecipeGen::new);
    }
}
