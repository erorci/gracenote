package com.emerson.soccer.api.match;

import com.emerson.soccer.api.serialization.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Action implements JsonSerializable {
    private final ResourceId id;
    private final ActionType type;
    private final Period period;
    private final long startTime;
    private final long endTime;
    private final HomeOrAway homeOrAway;
    private final ActionInvolved actionInvolved;


    public Action(ResourceId id,
                  ActionType type,
                  Period period,
                  long startTime,
                  long endTime,
                  HomeOrAway homeOrAway,
                  ActionInvolved actionInvolved) {
        this.id = id;
        this.type = type;
        this.period = period;
        this.startTime = startTime;
        this.endTime = endTime;
        this.homeOrAway = homeOrAway;
        this.actionInvolved = actionInvolved;
    }

    public ActionType type() {
        return type;
    }

    @Override
    public void writeJson(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeNumberField("id", id.Value());
        jsonGenerator.writeStringField("action", type.toString());
        jsonGenerator.writeStringField("period", period.toString());
        jsonGenerator.writeNumberField("startTime", startTime);
        jsonGenerator.writeNumberField("endTime", endTime);
        jsonGenerator.writeStringField("homeOrAway", homeOrAway.toString());
        jsonGenerator.writeObjectField("involved", actionInvolved);
    }
}
