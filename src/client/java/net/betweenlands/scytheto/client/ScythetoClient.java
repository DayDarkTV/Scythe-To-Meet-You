package net.betweenlands.scytheto.client;

import net.betweenlands.scytheto.Scytheto;
import net.betweenlands.scytheto.client.render.DynamicScytheRenderer;
import net.betweenlands.scytheto.items.ScythetoItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ScythetoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DynamicScytheRenderer ren = new DynamicScytheRenderer();
        ScythetoItems.SCYTHES.forEach(scytheItem -> BuiltinItemRendererRegistry.INSTANCE.register(scytheItem, ren));

        ModelLoadingPlugin.register((context) -> ScythetoItems.SCYTHES.forEach(scytheItem -> {
            Identifier id = Registries.ITEM.getId(scytheItem);
            context.addModels(id.withPath(path -> "item/" + path + "_in_hand"));
            context.addModels(id.withPath(path -> "item/" + path + "_inventory"));
        }));
        ModelLoadingPlugin.register(pluginContext -> pluginContext.addModels(Scytheto.getId("item/dummy_scythe")));
    }
}
