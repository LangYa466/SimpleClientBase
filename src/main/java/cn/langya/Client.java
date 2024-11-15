package cn.langya;

import cn.langya.config.ConfigManager;
import cn.langya.element.ElementManager;
import cn.langya.event.EventManager;
import cn.langya.module.ModuleManager;
import cn.langya.value.ValueManager;
import lombok.Getter;
import org.lwjgl.opengl.Display;

/**
 * @author LangYa
 * @since 2024/11/16 03:35
 */
@Getter
public class Client {
    @Getter
    private static final Client instance = new Client();

    public static final String name = "ClientBase";
    public static final double version = 0.1;

    private final EventManager eventManager = new EventManager();
    private ElementManager elementManager;
    private ModuleManager moduleManager;
    private ValueManager valueManager;
    private ConfigManager configManager;

    public void initClient() {
        elementManager = new ElementManager();
        moduleManager = new ModuleManager();
        valueManager = new ValueManager();
        configManager = new ConfigManager();

        Display.setTitle(String.format("%s - %s",name,version));
        System.out.println("Client initialized");
    }

    public void stopClient() {
        configManager.saveAllConfig();
    }
}

