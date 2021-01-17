package com.emerson.soccer.api.match;

import java.util.HashMap;
import java.util.Map;

public enum ActionType {
    BLOCKED_SHOT("Blocked shot"),
    CHANGE_OF_CAPTAIN("Change of captain"),
    CORNER("Corner"),
    DROP_BALL("Drop ball"),
    END_OF_PERIOD("End of period"),
    FOUL_COMMITED("Foul committed"),
    FREE_KICK("Free kick"),
    GOAL("Goal"),
    GOAL_KICK("Goal kick"),
    HIT_BAR("Hit bar"),
    HIT_POST("Hit post"),
    INJURY_TIME("Injury time"),
    KICK_OFF("Kick-off"),
    LINE_UP("Line-up"),
    OFFSIDE("Offside"),
    OWN_GOAL("Own goal"),
    PENALTY_MISSED("Penalty missed"),
    RED_2("Red (2 yellow)"),
    RED_STRAIGHT("Red (straight)"),
    SAVE_BY_GOALKEEPER("Save by goalkeeper"),
    SAVE_BY_PLAYER("Save by player"),
    SCORING_OPPORTUNITY("Scoring Opportunity"),
    SHOT_BLOCKED_BY("Shot blocked by"),
    SHOT_ON_GOAL("Shot on goal"),
    SHOT_WIDE("Shot wide"),
    SUBSTITUTION("Substitution"),
    VAR("Video Assistant Referee"),
    YELLOW("Yellow");

    private static final Map<String, ActionType> BY_LABEL = new HashMap<>();

    static {
        for (ActionType e: values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public final String label;

    ActionType(String label) {
        this.label = label;
    }

    public static ActionType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
