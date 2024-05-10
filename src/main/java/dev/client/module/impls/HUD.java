package dev.client.module.impls;

import com.cubk.event.annotations.EventTarget;
import dev.client.Client;
import dev.client.event.impls.render.EventRender2D;
import dev.client.font.CFontRenderer;
import dev.client.font.FontManager;
import dev.client.module.Category;
import dev.client.module.Module;

import java.util.ArrayList;

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
        CFontRenderer font = FontManager.sfui18;
        enabledModules.sort((m1, m2) -> {
            int width1 = FontManager.sfui18.getStringWidth(m1.getName());
            int width2 = FontManager.sfui18.getStringWidth(m2.getName());
            return Float.compare(width1, width2);
        });
        for (Module module : enabledModules) {
            int moduleWidth = font.getStringWidth(module.getName());
            font.drawStringWithShadow(module.getName(), width - moduleWidth - 4, y, -1);
            y += font.getFontHeight() + 3;
        }
    }

}
