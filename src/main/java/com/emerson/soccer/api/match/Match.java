package com.emerson.soccer.api.match;

import com.emerson.soccer.api.competition.Competition;
import com.emerson.soccer.api.serialization.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class Match implements JsonSerializable {
    private final ResourceId id;
    private final Summary summary;
    private final LocalDate date;
    private final Competition competition;

    public Match(ResourceId id,
                 Summary summary,
                 LocalDate date,
                 Competition competition) {
        this.id = id;
        this.summary = summary;
        this.date = date;
        this.competition = competition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id);
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", summary=" + summary +
                ", date=" + date +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String competitionName() {
        return competition.name();
    }

    public long id() {
        return id.Value();
    }

    @Override
    public void writeJson(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeNumberField("Id", id.Value());
        jsonGenerator.writeObjectField("competition", competition.name());
        jsonGenerator.writeStringField("date", date.toString());
        jsonGenerator.writeObjectField("summary", summary);
    }
}
