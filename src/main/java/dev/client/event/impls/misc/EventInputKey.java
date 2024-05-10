package dev.client.event.impls.misc;

import com.cubk.event.impl.Event;
import lombok.Getter;
import lombok.Setter;

/**
 * @author LangYa466
 * @date 2024/5/10 16:49
 */

@Getter
@Setter
public class EventInputKey implements Event {
    int keyCode;

    public EventInputKey(int keyCode) {
        this.keyCode = keyCode;
    }
}
