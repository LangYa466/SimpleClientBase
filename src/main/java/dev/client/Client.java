package dev.client;

import com.cubk.event.EventManager;
import dev.client.module.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author LangYa466
 * @date 2024/5/10 16:40
 */

public class Client {

    public static String name = "SimpleClientBase";

    public static Logger logger =  LogManager.getLogger(name);

    // managers
    public static EventManager eventManager;
    public static ModuleManager moduleManager;
    public static void startClient() {
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
    }

    public static void stopClient() { }

}
