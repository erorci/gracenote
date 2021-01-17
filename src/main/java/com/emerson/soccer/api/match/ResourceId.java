package com.emerson.soccer.api.match;

import java.util.Objects;

public class ResourceId {

    private final long value;

    private ResourceId(long value) {
        this.value = value;
    }

    public static ResourceId of(long value) {
        return new ResourceId(value);
    }

    public static ResourceId fromString(String value) {
        return new ResourceId(Long.parseLong(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceId that = (ResourceId) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ResourceId{" +
                "value=" + value +
                '}';
    }

    public long Value() {
        return value;
    }
}
