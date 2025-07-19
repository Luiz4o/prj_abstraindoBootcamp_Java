package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Content> subscribedContent = new LinkedHashSet<>();
    private Set<Content> finishedContents = new LinkedHashSet<>();

    public void subscribBootcamp(Bootcamp bootcamp){
        this.subscribedContent.addAll(bootcamp.getContents());
        bootcamp.getSubscribedDevs().add(this);
    }

    public void toProgress(){
        var content = this.subscribedContent.stream().findFirst();
        this.finishedContents.add(content.orElseThrow(() -> new NoSuchElementException("Você não possui curso para progredir")));
        this.subscribedContent.remove(content.get());
    }

    public double calculateXp(){
        return this.finishedContents.stream()
                .mapToDouble(Content::calculateXP)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getFinishedContents() {
        return finishedContents;
    }

    public void setFinishedContents(Set<Content> finishedContents) {
        this.finishedContents = finishedContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getSubscribedContent(), dev.getSubscribedContent()) && Objects.equals(getFinishedContents(), dev.getFinishedContents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSubscribedContent(), getFinishedContents());
    }
}
