package com.emerson.soccer.api.match;

public enum HomeOrAway {
    HOME(1),
    AWAY (-1),
    NEUTRAL(0);

    public final int value;

    private HomeOrAway(int value) {
        this.value = value;
    }

    public static HomeOrAway fromValue(int value) {
        for (HomeOrAway e : values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }
}
