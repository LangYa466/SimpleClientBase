package dev.client.module;

import com.cubk.event.annotations.EventTarget;
import dev.client.Client;
import dev.client.Wrapper;
import dev.client.event.impls.misc.EventInputKey;
import dev.client.event.impls.misc.EventTick;
import dev.client.module.impls.HUD;
import dev.client.module.impls.Sprint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LangYa466
 * @date 2024/5/10 16:46
 */

@Getter
@Setter
public class ModuleManager implements Wrapper {
    List<Module> modules;

    public ModuleManager() {
        this.modules = new CopyOnWriteArrayList<>();
        this.registerModules();
        Client.eventManager.register(this);
    }

    private void registerModules() {
       this.modules.add(new Sprint());
        this.modules.add(new HUD());
    }

    @EventTarget
    private void onKeyInput(EventInputKey event) {
        this.modules.forEach(module -> {
            if (module.keyCode == event.getKeyCode()) module.toggle();
        });
    }

    @EventTarget
    private void onTick(EventTick event) {
        this.modules.forEach(module -> {
            if (module.isState()) Client.eventManager.register(module); else Client.eventManager.unregister(module);
        });
    }


}
