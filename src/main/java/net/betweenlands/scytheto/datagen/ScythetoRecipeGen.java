package net.betweenlands.scytheto.datagen;

import net.betweenlands.scytheto.items.ScytheItem;
import net.betweenlands.scytheto.items.ScythetoItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ScythetoRecipeGen extends FabricRecipeProvider {
    public ScythetoRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerScytheRecipe(recipeExporter, ScythetoItems.DIAMOND_SCYTHE, Items.DIAMOND);
        offerScytheRecipe(recipeExporter, ScythetoItems.IRON_SCYTHE, Items.IRON_INGOT);
        offerScytheRecipe(recipeExporter, ScythetoItems.STONE_SCYTHE, ItemTags.STONE_TOOL_MATERIALS);
        offerScytheRecipe(recipeExporter, ScythetoItems.GOLD_SCYTHE, Items.GOLD_INGOT);
        offerNetheriteUpgradeRecipe(recipeExporter, ScythetoItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, ScythetoItems.NETHERITE_SCYTHE);

        SmithingTransformRecipeJsonBuilder.create(Ingredient.empty(), Ingredient.ofItems(ScythetoItems.NETHERITE_SCYTHE), Ingredient.ofItems(Items.PINK_PETALS), RecipeCategory.TOOLS, ScythetoItems.PHARI_SCYTHE)
                .criterion("has_netherite_scythe", conditionsFromItem(ScythetoItems.NETHERITE_SCYTHE))
                .offerTo(recipeExporter, getItemPath(ScythetoItems.PHARI_SCYTHE) + "_smithing");
    }

    public static void offerScytheRecipe(RecipeExporter recipeExporter, ScytheItem scythe, Item ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, scythe)
                .pattern("XX ")
                .pattern(" #X")
                .pattern("#  ")
                .input('#', Items.STICK)
                .input('X', ingredient)
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(recipeExporter);
    }
    public static void offerScytheRecipe(RecipeExporter recipeExporter, ScytheItem scythe, TagKey<Item> ingredient) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, scythe)
                .pattern("XXX")
                .pattern(" #X")
                .pattern("#  ")
                .input('#', Items.STICK)
                .input('X', ingredient)
                .criterion(hasTag(ingredient), conditionsFromTag(ingredient))
                .offerTo(recipeExporter);
    }

    public static String hasTag(TagKey<Item> tag) {
        return "has_" + tag.id().getPath();
    }
}
