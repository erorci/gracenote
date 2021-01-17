package com.emerson.soccer.api.match;

import java.io.Serializable;
import java.util.Objects;

public class Team implements Serializable {
    private final String name;

    private Team(String name) {
        this.name = name;
    }

    public static Team withName(String name) {
        return new Team(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
