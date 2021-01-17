package com.emerson.soccer.api.competition;

import com.emerson.soccer.api.serialization.JsonSerializable;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.Objects;

public class Competition implements JsonSerializable, Comparable<Competition> {

    private final String name;

    private Competition(String name) {
        this.name = name;
    }

    public static Competition withName(String name) {
        return new Competition(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Competition{" +
                "name='" + name + '\'' +
                '}';
    }

    public String name() {
        return name;
    }

    @Override
    public void writeJson(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStringField("name", name);
    }

    @Override
    public int compareTo(Competition competition) {
        int last = this.name.compareTo(competition.name);
        return last == 0 ? this.name.compareTo(competition.name) : last;
    }
}
