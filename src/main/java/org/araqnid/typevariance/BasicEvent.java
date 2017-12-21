package org.araqnid.typevariance;

import java.util.Objects;

public final class BasicEvent implements Event {
    private final String text;

    public BasicEvent(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicEvent that = (BasicEvent) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "BasicEvent{" +
                "text='" + text + '\'' +
                '}';
    }
}
