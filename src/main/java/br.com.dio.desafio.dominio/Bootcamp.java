package br.com.dio.desafio.dominio;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String name;
    private String description;
    private final OffsetDateTime startDate = OffsetDateTime.now();
    private final OffsetDateTime endDate = startDate.plusDays(45);
    private Set<Dev> subscribedDevs = new HashSet<>();
    private Set<Content> contents = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public Set<Dev> getSubscribedDevs() {
        return subscribedDevs;
    }

    public void setSubscribedDevs(Set<Dev> subscribedDevs) {
        this.subscribedDevs = subscribedDevs;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp bootcamp)) return false;
        return Objects.equals(getName(), bootcamp.getName()) && Objects.equals(getDescription(), bootcamp.getDescription()) && Objects.equals(getStartDate(), bootcamp.getStartDate()) && Objects.equals(getEndDate(), bootcamp.getEndDate()) && Objects.equals(getSubscribedDevs(), bootcamp.getSubscribedDevs()) && Objects.equals(getContents(), bootcamp.getContents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getStartDate(), getEndDate(), getSubscribedDevs(), getContents());
    }
}
