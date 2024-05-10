package dev.client.module;

import dev.client.Wrapper;
import lombok.Getter;
import lombok.Setter;

/**
 * @author LangYa466
 * @date 2024/5/10 16:44
 */


@Getter
@Setter
public class Module implements Wrapper {
    String name;
    boolean state;
    int keyCode;
    Category category;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Module(String name, Category category, int keyCode) {
        this.name = name;
        this.category = category;
        this.keyCode = keyCode;
    }

    public void toggle() {
        this.state = !this.state;
    }
}

