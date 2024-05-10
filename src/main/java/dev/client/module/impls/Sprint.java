package dev.client.module.impls;

import com.cubk.event.annotations.EventTarget;
import dev.client.event.impls.player.EventUpdatePlayer;
import dev.client.module.Category;
import dev.client.module.Module;

/**
 * @author LangYa466
 * @date 2024/5/10 16:56
 */

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.Move);
        this.setState(true);
    }

    @EventTarget
    void onUpdatePlayer(EventUpdatePlayer event) {
        mc.gameSettings.keyBindSprint.pressed = true;
    }

}
