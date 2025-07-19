package br.com.dio.desafio.dominio;

import java.time.OffsetDateTime;

public class Mentoring extends Content {

    private OffsetDateTime date;

    @Override
    public double calculateXP() {
        return XP_DEFAULT + 20d;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                ", title=" + getTitle() +
                ", desciption=" + getDescription() +
                ", date=" + date +
                '}';
    }
}
