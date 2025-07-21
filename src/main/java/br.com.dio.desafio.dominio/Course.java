package br.com.dio.desafio.dominio;

public class Course extends Content {

    private int workload;

    public Course() {
    }

    public Course(String title, String description, int workload) {
        super(title,description);
        this.workload = workload;
    }

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
        return "Titulo = " + getTitle() + '\n' +
                "Descricao = " + getDescription() + '\n' +
                "Carga Horaria = " + workload + '\n';
    }
}
