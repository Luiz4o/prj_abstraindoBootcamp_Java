package br.com.dio.desafio.dominio;

import javax.swing.text.DateFormatter;
import java.text.Format;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Mentoring extends Content {

    private OffsetDateTime date;

    public Mentoring(String title, String description, OffsetDateTime date) {
        super(title, description);
        this.date = date;
    }

    public Mentoring() {
    }

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ssXXX");

        return "Titulo : " + getTitle() + '\n' +
                "Descricao : " + getDescription() + '\n' +
                "Data :" + date.format(formatter) + '\n';
    }
}
