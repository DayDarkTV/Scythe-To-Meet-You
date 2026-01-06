package net.betweenlands.scytheto.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class DynamicScytheRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        boolean inInventory = mode == ModelTransformationMode.GUI;
        boolean inHand = mode.isFirstPerson() || mode == ModelTransformationMode.THIRD_PERSON_LEFT_HAND || mode == ModelTransformationMode.THIRD_PERSON_RIGHT_HAND || mode == ModelTransformationMode.HEAD;

        Identifier itemPath = Registries.ITEM.getId(stack.getItem());
        BakedModel model = MinecraftClient.getInstance().getBakedModelManager().getModel(itemPath.withPath(path -> "item/" + path + (inHand ? "_in_hand" : "_inventory")));

        boolean isLeftHand = mode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND || mode == ModelTransformationMode.THIRD_PERSON_LEFT_HAND;

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);

        if (inInventory) DiffuseLighting.disableGuiDepthLighting();

        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, mode, isLeftHand, matrices, vertexConsumers, light, overlay, model);
        if (vertexConsumers instanceof VertexConsumerProvider.Immediate immediate) immediate.draw();

        if (inInventory) DiffuseLighting.enableGuiDepthLighting();

        matrices.pop();
    }
}
