package dev.client.util.impl.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

/**
 * @author LangYa466
 * @date 2024/5/10 17:07
 */

public class RenderUtil {
    public static void drawTexture(int texture, float x, float y, float width, float height, float u, float v, int textureWidth, int textureHeight) {
        float xTexel = 1.0F / textureWidth;
        float yTexel = 1.0F / textureHeight;

        GlStateManager.bindTexture(texture);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x, y + height, 0.0).tex(u * xTexel, (v + height) * yTexel).endVertex();
        worldrenderer.pos(x + width, y + height, 0.0).tex((u + width) * xTexel, (v + height) * yTexel).endVertex();
        worldrenderer.pos(x + width, y, 0.0).tex((u + width) * xTexel, v * yTexel).endVertex();
        worldrenderer.pos(x, y, 0.0).tex(u * xTexel, v * yTexel).endVertex();
        tessellator.draw();
    }



    public static void color(int r,int g,int b,int a) {
        GlStateManager.color(r / 255.0f,g / 255.0f,b / 255.0f,a / 255.0f);
    }

    public static void color(int hex) {
        GlStateManager.color(
                (hex >> 16 & 0xFF) / 255.0f,
                (hex >> 8 & 0xFF) / 255.0f,
                (hex & 0xFF) / 255.0f,
                (hex >> 24 & 0xFF) / 255.0f);
    }


}
