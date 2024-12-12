package victorgponce.com.aurigasNorenderpiglin.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AurigasNorenderpiglinClient implements ClientModInitializer {

    public static final String MOD_ID_CLIENT = "aurigas-norenderpiglin";
    public static final Logger LOGGER_CLIENT = LoggerFactory.getLogger(MOD_ID_CLIENT);

    @Override
    public void onInitializeClient() {
        LOGGER_CLIENT.info("[No Render Piglin] Inicializando el mod...");
        LOGGER_CLIENT.info("[No Render Piglin] Creado por Ponchisao326");

        // Se registra el piglin
        EntityRendererRegistry.register(EntityType.PIGLIN, NoRenderEntityRenderer::new);
    }

    private static class NoRenderEntityRenderer<T extends Entity> extends EntityRenderer<T> {
        protected NoRenderEntityRenderer(EntityRendererFactory.Context context) {
            super(context);
        }

        @Override
        public void render(T entity, float yaw, float tickDelta, MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
            // Se deshabilida el render.
        }

        @Override
        public Identifier getTexture(T entity) {
            return null; // Quitamos la textura pues no se renderiza.
        }
    }
}
