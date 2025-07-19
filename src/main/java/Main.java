import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Mentoring;

import java.time.OffsetDateTime;

public class Main {

    public static void main(String[] args) {
        Course courseJava = new Course();
        courseJava.setTitle("Course for Java beginner");
        courseJava.setDescription("This course shows you the first steps in Java.");
        courseJava.setWorkload(16);

        Course coursePython = new Course();
        coursePython.setTitle("Course for Python beginner");
        coursePython.setDescription("This course shows you the first steps in Python.");
        coursePython.setWorkload(16);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java Mentoring");
        mentoring.setDescription("Mentoring for learning Java.");
        mentoring.setDate(OffsetDateTime.now());

        System.out.println(courseJava);
        System.out.println(coursePython);
        System.out.println(mentoring);
    }
}
