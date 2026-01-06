package net.betweenlands.scytheto.datagen;

import net.betweenlands.scytheto.Scytheto;
import net.betweenlands.scytheto.items.ScytheItem;
import net.betweenlands.scytheto.items.ScythetoItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ScythetoModels extends FabricModelProvider {
    public static final Model BIG_WEAPON = item("big_weapon", TextureKey.LAYER0);

    public ScythetoModels(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        registerBigWeapon(ScythetoItems.DIAMOND_SCYTHE, itemModelGenerator);
        for (ScytheItem scythe : ScythetoItems.SCYTHES) registerBigWeapon(scythe, itemModelGenerator);
    }

    public static void registerBigWeapon(Item item, ItemModelGenerator generator) {
        registerInInv(item, generator);
        registerInHand(item, generator);
        registerBuiltin(item, generator);
    }
    public static void registerInInv(Item item, ItemModelGenerator generator) {
        Identifier name = Registries.ITEM.getId(item).withPath(path -> "item/" + path + "_inventory");
        Models.HANDHELD.upload(name, TextureMap.layer0(name), generator.writer);
    }
    public static void registerInHand(Item item, ItemModelGenerator generator) {
        Identifier modelName = Registries.ITEM.getId(item).withPath(path -> "item/" + path + "_in_hand");
        BIG_WEAPON.upload(modelName, TextureMap.layer0(item), generator.writer);
    }
    public static void registerBuiltin(Item item, ItemModelGenerator generator) {
        generator.register(item, new Model(Optional.of(Identifier.of("builtin/entity")), Optional.empty()));
    }

    private static Model item(String parent, TextureKey requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Scytheto.MOD_ID, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
