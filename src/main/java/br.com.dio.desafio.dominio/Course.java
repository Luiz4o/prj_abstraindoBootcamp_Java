package br.com.dio.desafio.dominio;

public class Course extends Content {

    private int workload;

    @Override
    public double calculateXP() {
        return XP_DEFAULT * workload;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", workload='" + workload + '\'' +
                '}';
    }
}
