package dev.client.module.impls;

import com.cubk.event.annotations.EventTarget;
import dev.client.Client;
import dev.client.event.impls.render.EventRender2D;
import dev.client.module.Category;
import dev.client.module.Module;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author LangYa466
 * @date 2024/5/10 17:01
 */

public class HUD extends Module {
    public HUD() {
        super("HUD", Category.Render);
        this.setState(true);
    }

    @EventTarget
    void onRender2D(EventRender2D e) {

        int width = e.getScaledResolution().getScaledWidth();
        int y = 4;
        ArrayList<Module> enabledModules = new ArrayList<>();
        for (Module m : Client.moduleManager.getModules()) {
            if (m.isState()) enabledModules.add(m);
        }
        FontRenderer font = mc.fontRendererObj;
        for (Module module : enabledModules) {
            int moduleWidth = font.getStringWidth(module.getName());
            font.drawStringWithShadow(module.getName(), width - moduleWidth - 4, y, -1);
            y += font.FONT_HEIGHT + 3;
        }
    }

}
