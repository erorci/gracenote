package com.emerson.soccer.api.match;

import com.emerson.soccer.api.serialization.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatchActions implements JsonSerializable {
    private final Match match;
    private final List<Action> actions;

    public MatchActions(Match match) {
        this.match = match;
        this.actions = new ArrayList<>();
    }

    public MatchActions add(Action action) {
        actions.add(action);
        return this;
    }

    public MatchActions addAll(List<Action> actions) {
        this.actions.addAll(actions);
        return this;
    }

    public MatchActions removeActions() {
        this.actions.clear();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchActions match = (MatchActions) o;
        return Objects.equals(match, match);
    }

    @Override
    public String toString() {
        return "Match{" +
                "match=" + match.toString() +
                ", actions=" + actions.toString() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(match);
    }

    public long matchId() {
        return match.id();
    }

    public List<Action> actions() {
        return new ArrayList<>(actions);
    }

    public Match match() {
        return match;
    }

    @Override
    public void writeJson(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeObjectField("match", match);
        jsonGenerator.writeArrayFieldStart("actions");
        for (Action action : actions) {
            jsonGenerator.writeStartObject();
            action.writeJson(jsonGenerator);
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
