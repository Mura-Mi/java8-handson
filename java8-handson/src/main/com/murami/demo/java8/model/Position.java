package com.murami.demo.java8.model;

public enum Position {

    PITCHER(true),

    CATCHER(true),

    FIRST_BASEMAN(true),

    SECOND_BASEMAN(true),

    THIRD_BASEMAN(true),

    SHORT_STOP(true),

    LEFT_FIELDER(true),

    CENTER_FIELDER(true),

    RIGHT_FIELDER(true),

    DESIGNATED_HITTER(true),

    COATCH(false),

    MANAGER(false);

    private final boolean isPlayable;

    private Position(boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

}
