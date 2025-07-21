package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class Dev {
    private String name;
    private Set<Content> subscribedContent = new LinkedHashSet<>();
    private Set<Content> finishedContents = new LinkedHashSet<>();

    public Dev() {
    }

    public Dev(String name) {
        this.name = name;
    }

    public void subscribeBootcamp(Bootcamp bootcamp){
        this.subscribedContent.addAll(bootcamp.getContents());
        bootcamp.subscribeDev(this);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(getName(), dev.getName()) && Objects.equals(getSubscribedContent(), dev.getSubscribedContent()) && Objects.equals(getFinishedContents(), dev.getFinishedContents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubscribedContent(), getFinishedContents());
    }

    @Override
    public String toString() {
        return  "Nome = " + name + '\n' +
                "Conteudos inscritos = " + subscribedContent + '\n' +
                "Conteudos finalizados =" + finishedContents + '\n';
    }
}
