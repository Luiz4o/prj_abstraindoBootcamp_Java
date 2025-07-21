import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Content;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoring;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Dev> devList = new ArrayList<>();
    private static List<Bootcamp> bootcamps = new ArrayList<>();
    private static Set<Content> contents = new LinkedHashSet<>();

    public static void main(String[] args) {

        int option;

        do {
            showMenu();
            option = scanner.nextInt();

            switch (option){
                case 1 -> showMenuDev();
                case 2 -> showMenuBootcamp();
                case 3 -> System.out.println("Até a próxima!!");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 3);



        Course courseJava = new Course();
        courseJava.setTitle("Course for Java beginner");
        courseJava.setDescription("This course shows you the first steps in Java.");
        courseJava.setWorkload(16);

        Course courseAWS = new Course();
        courseAWS.setTitle("Course for AWS beginner");
        courseAWS.setDescription("This course shows you the first steps in AWS.");
        courseAWS.setWorkload(16);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java Mentoring");
        mentoring.setDescription("Mentoring for learning Java.");
        mentoring.setDate(OffsetDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Description Bootcamp Java Developer");
        bootcamp.addContent(courseAWS);
        bootcamp.addContent(courseJava);
        bootcamp.addContent(mentoring);

        Dev devLuiz = new Dev();
        devLuiz.setName("Luiz");
        devLuiz.subscribeBootcamp(bootcamp);
        System.out.println(devLuiz.getSubscribedContent());
        devLuiz.toProgress();
        devLuiz.toProgress();
        devLuiz.toProgress();
        System.out.println(devLuiz.getFinishedContents());
        System.out.println(devLuiz.getSubscribedContent());
        System.out.println(devLuiz.calculateXp());

        Dev devCamila = new Dev();
        devCamila.setName("Camila");
        devCamila.subscribeBootcamp(bootcamp);

    }

    private static void showMenu() {
        System.out.println("""
                    ======================================================
                    Bem vindo a plataforma de cursos da DIO!
                    Temos algumas opções para você caro usuário
                                    
                    1 - Área Dev
                    2 - Gereneciar Bootcamp
                    3 - Sair
                    """);
    }

    private static void showMenuDev(){
        int option;

        do {
            System.out.println("""
                    ======================================================
                    Bem vindo Dev, o que vamos realizar hoje?
                    1 - Inscrever novo Dev
                    2 - Inscrever-se em um bootcamp
                    3 - Exibir detalhes do bootcamp
                    4 - Avançar no bootcamp
                    5 - Ver seu XP
                    6 - Listar Devs
                    7 - Sair
                    """);
            option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Informe o nome do mais novo Dev: ");
                    var name = scanner.next();
                    Dev newDev = new Dev(name);
                    devList.add(newDev);
                }

                case 2 -> {
                    if (!bootcamps.isEmpty()) {
                        System.out.println("""
                                ======================================================
                                Informe o nome completo do Dev :
                                """);
                        var name = scanner.next().trim();

                        Optional<Dev> optionalDev = devList.stream()
                                .filter(dev -> dev.getName().trim().equalsIgnoreCase(name))
                                .findFirst();

                        System.out.println("Escolha um bootcamp para se inscrever");
                        bootcamps.forEach(b -> System.out.printf("%s - %s\n", bootcamps.indexOf(b) + 1, b.getName()));

                        var bootcampOption = scanner.nextInt() - 1;

                        var getBootcamp = bootcamps.get(bootcampOption);
                        try {
                            var dev = optionalDev.orElseThrow();
                            dev.subscribeBootcamp(getBootcamp);
                        } catch (Exception e) {
                            System.out.println("Dev informado não encontrado na nossa lista de inscritos na plataforma!");
                        }

                    } else {
                        System.out.println("Não há bootcamps no momento para se inscriver!");
                    }


                }

                case 3 -> {
                    System.out.println("""
                            ======================================================
                            Escolha um bootcamp para exibir mais detalhes :
                            """);
                    bootcamps.forEach(b -> System.out.printf("%s - %s\n", bootcamps.indexOf(b) + 1, b.getName()));

                    var bootcampOption = scanner.nextInt() - 1;

                    var getBootcamp = bootcamps.get(bootcampOption);

                    System.out.printf("Detalhes do bootcamp %s \n%s\n", getBootcamp.getName(), getBootcamp.getDescription());
                }

                case 4 -> {
                    System.out.println("""
                            ======================================================
                            Informe o nome completo do Dev :
                            """);
                    var name = scanner.next().trim();

                    Optional<Dev> optionalDev = devList.stream()
                            .filter(dev -> dev.getName().trim().equalsIgnoreCase(name))
                            .findFirst();

                    try {
                        var dev = optionalDev.orElseThrow();

                        dev.toProgress();
                    } catch (Exception e) {
                        System.out.println("Dev informado não encontrado na nossa lista de inscritos na plataforma!");
                    }
                }

                case 5 -> {
                    System.out.println("""
                            ======================================================
                            Informe o nome completo do Dev :
                            """);
                    var name = scanner.next().trim();

                    Optional<Dev> optionalDev = devList.stream()
                            .filter(dev -> dev.getName().trim().equalsIgnoreCase(name))
                            .findFirst();

                    try {
                        var dev = optionalDev.orElseThrow();
                        System.out.printf("Parabéns %s, seu XP atual é %.2f\n", dev.getName(), dev.calculateXp());
                    } catch (Exception e) {
                        System.out.println("Dev informado não encontrado na nossa lista de inscritos na plataforma!");
                    }
                }

                case 6 -> devList.forEach(System.out::println);

                case 7 -> System.out.println("Até a próxima Dev!!");

                default -> System.out.println("Opcao inválida!");
            }
        }while (option != 7);

    }

    private static void showMenuBootcamp(){
        int option;
        do {
            System.out.println("""
                    ======================================================
                    Bem vindo Admin, Qual recurso vamos atualizar hoje?
                    1 - Adicionar Curso
                    2 - Adicionar Mentoria
                    3 - Iniciar novo bootcamp
                    4 - Listar devs inscritos no bootcamp
                    5 - Sair
                    """);
            option = scanner.nextInt();
            switch (option) {

                case 1 -> {
                    System.out.println("Informe o nome do curso :");
                    var courseName = scanner.next();
                    System.out.println("Informe a descricao do curso :");
                    var courseDescription = scanner.next();
                    System.out.println("Informe a carga horaria do curso(Em horas):");
                    var courseWorkload = scanner.nextInt();

                    Content course = new Course(courseName, courseDescription, courseWorkload);
                    contents.add(course);
                }

                case 2 -> {
                    System.out.println("Informe o nome da mentoria :");
                    var mentoringName = scanner.next();
                    System.out.println("Informe a descricao da mentoria :");
                    var mentoringDescription = scanner.next();

                    Content mentoring = new Mentoring(mentoringName, mentoringDescription, OffsetDateTime.now());
                    contents.add(mentoring);
                }

                case 3 -> {
                    System.out.println("Informe o nome do bootcamp :");
                    var bootcampName = scanner.next();
                    System.out.println("Informe a descricao do bootcamp :");
                    var bootcampDescription = scanner.next();
                    var bootcamp = new Bootcamp(bootcampName, bootcampDescription);

                    int selectedOption;
                    int count = 1;

                    do {
                        System.out.println("Informe um conteúdo para inserir (ou 0 para sair):");

                        List<Content> contentsNotAdd = contents.stream()
                                .filter(content -> !bootcamp.getContents().contains(content))
                                .toList();

                        for (int i = 0; i < contentsNotAdd.size(); i++) {
                            System.out.printf("%d - %s%n", i + 1, contentsNotAdd.get(i).getTitle());
                        }

                        selectedOption = scanner.nextInt();

                        if (selectedOption > 0 && selectedOption <= contentsNotAdd.size()) {
                            Content contentSelected = contentsNotAdd.get(selectedOption - 1);
                            bootcamp.getContents().add(contentSelected);
                            System.out.println("Conteúdo adicionado com sucesso!");
                        } else if (selectedOption != 0) {
                            System.out.println("Opção inválida!");
                        }
                    } while (selectedOption != 0);

                    bootcamps.add(bootcamp);

                }

                case 4 -> {
                    System.out.println("""
                            ======================================================
                            Escolha um bootcamp  :
                            """);
                    bootcamps.forEach(b -> System.out.printf("%s - %s\n", bootcamps.indexOf(b) + 1, b.getName()));

                    var bootcampOption = scanner.nextInt() - 1;

                    var getBootcamp = bootcamps.get(bootcampOption);

                    bootcamps.forEach(b -> b.getSubscribedDevs().forEach(d -> System.out.println(d.getName())));
                }

                case 5 -> System.out.println("Até a próxima Adm!!");

                default -> System.out.println("Opcao inválida!");
            }
        } while (option != 5);

    }
}
