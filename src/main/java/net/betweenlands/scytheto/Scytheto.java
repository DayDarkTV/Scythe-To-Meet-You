package net.betweenlands.scytheto;

import net.betweenlands.scytheto.items.ScythetoItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scytheto implements ModInitializer {
    public static final String MOD_ID = "scytheto";
    public static final Logger LOGGER = LoggerFactory.getLogger("Scythe To Meet You");

    @Override
    public void onInitialize() {
        ScythetoItems.init();
    }

    public static Identifier getId(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
