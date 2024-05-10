package dev.client.event.impls.render;

import com.cubk.event.impl.Event;
import lombok.Getter;
import net.minecraft.client.gui.ScaledResolution;

/**
 * @author LangYa466
 * @date 2024/5/10 17:00
 */

@Getter
public class EventRender2D implements Event {
    ScaledResolution scaledResolution;
    float partialTicks;

    public EventRender2D(ScaledResolution scaledResolution, float partialTicks) {
        this.scaledResolution = scaledResolution;
        this.partialTicks = partialTicks;
    }

}
