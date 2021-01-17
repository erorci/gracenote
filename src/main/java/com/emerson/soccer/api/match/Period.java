package com.emerson.soccer.api.match;

import java.util.HashMap;
import java.util.Map;

public enum Period {
    START("Start"),
    FIRST_HALF("First half"),
    SECOND_HALF("Second half"),
    HALF("Half time"),
    NONE("NULL");

    private static final Map<String, Period> BY_LABEL = new HashMap<>();

    static {
        for (Period e: values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public final String label;

    Period(String label) {
        this.label = label;
    }

    public static Period valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
