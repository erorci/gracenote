package com.emerson.soccer.api.match;

import com.emerson.soccer.api.serialization.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class Summary implements JsonSerializable {
    private final Team home;
    private final Team away;
    private final int homeGoals;
    private final int awayGoals;

    public Summary(Team home, Team away, int homeGoals, int awayGoals) {
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    @Override
    public void writeJson(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStringField("teamHome", home.toString());
        jsonGenerator.writeStringField("teamAway", away.toString());
        jsonGenerator.writeNumberField("homeGoals", homeGoals);
        jsonGenerator.writeNumberField("awayGoals", awayGoals);
    }
}
