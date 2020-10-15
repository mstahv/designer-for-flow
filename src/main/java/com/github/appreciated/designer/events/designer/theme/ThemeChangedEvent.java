package com.github.appreciated.designer.events.designer.theme;

import com.github.appreciated.designer.model.CssVariable;
import org.springframework.context.ApplicationEvent;

public class ThemeChangedEvent extends ApplicationEvent {

    private final CssVariable cssVariable;

    public ThemeChangedEvent(Object source, CssVariable cssVariable) {
        super(source);
        this.cssVariable = cssVariable;
    }

    public CssVariable getCssVariable() {
        return cssVariable;
    }
}
