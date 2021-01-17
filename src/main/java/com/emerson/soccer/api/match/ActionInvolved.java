package com.emerson.soccer.api.match;

import com.emerson.soccer.api.serialization.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class ActionInvolved implements JsonSerializable {
    private final Team team;
    private final String person;
    private final String reason;
    private final String subPerson;

    public ActionInvolved(Team team,
                          String person,
                          String reason,
                          String subPerson) {
        this.team = team;
        this.person = person;
        this.reason = reason;
        this.subPerson = subPerson;
    }

    @Override
    public void writeJson(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStringField("team", (team != null) ? team.toString() : null);
        jsonGenerator.writeStringField("person", person);
        jsonGenerator.writeStringField("reason", reason);
        jsonGenerator.writeStringField("subPerson", subPerson);
    }
}
