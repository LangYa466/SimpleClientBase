package dev.client.font;

import dev.client.Client;

import java.awt.*;
import java.io.InputStream;

public class FontManager {

    public static Font getFont(String name, int size) {
        Font font;
        try {
            InputStream is = FontManager.class.getResourceAsStream("/assets/minecraft/client/fonts/" + name);
            font = Font.createFont(0, is);
            font = font.deriveFont(Font.PLAIN, size);
        } catch (Exception ex) {
            Client.logger.error("Error loading font {}", name);
            font = new Font("Arial", Font.PLAIN, size);
        }
        return font;
    }

}