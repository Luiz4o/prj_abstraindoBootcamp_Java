# Abstraindo um Bootcamp com Java

> Projeto desenvolvido como parte do Desafio de Projeto "Abstraindo um Bootcamp Usando Orientação a Objetos em Java" da Digital Innovation One (DIO).

## 📜 Sobre o Projeto

Este projeto tem como objetivo aplicar os conceitos fundamentais da Programação Orientada a Objetos (POO) em Java para modelar e simular a estrutura de um Bootcamp. Ele representa as entidades principais de um bootcamp, como Devs (participantes), Cursos, Mentorias e o próprio Bootcamp, demonstrando como elas se relacionam.

Um desenvolvedor pode se inscrever em um bootcamp, progredir nos conteúdos (cursos e mentorias), e ao final, ter o cálculo do seu XP (experiência) total.

## ✨ Funcionalidades Principais

* Criação de Cursos e Mentorias.
* Criação e gerenciamento de um Bootcamp, adicionando conteúdos a ele.
* Inscrição de Desenvolvedores (Devs) em um Bootcamp.
* Acompanhamento da progressão de um Dev nos conteúdos.
* Cálculo do XP total de um Dev ao concluir os conteúdos.

## 🛠️ Requisitos Iniciais

Para executar este projeto em sua máquina local, você precisará ter os seguintes softwares instalados:

* **Java Development Kit (JDK):** Versão 8 ou superior.
* **Git:** Para clonar o repositório (opcional, você pode baixar o ZIP).
* **Uma IDE (Ambiente de Desenvolvimento Integrado):** Como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [VS Code](https://code.visualstudio.com/) (recomendado para facilitar a compilação e execução).

## 🚀 Como Executar o Projeto

Siga os passos abaixo para compilar e executar a aplicação.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Luiz4o/prj_abstraindoBootcamp_Java.git](https://github.com/Luiz4o/prj_abstraindoBootcamp_Java.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd prj_abstraindoBootcamp_Java
    ```

3.  **Compile os arquivos Java:**
    Se estiver na pasta raiz do projeto via terminal, use o comando abaixo para compilar todos os arquivos e colocar os `.class` no diretório `bin`:
    ```bash
    javac -d bin src/br/com/dio/desafio/dominio/*.java src/Main.java
    ```

4.  **Execute a aplicação:**
    Após a compilação, execute a classe principal `Main`:
    ```bash
    java -cp bin Main
    ```
    Você verá a saída do programa no console, demonstrando a inscrição dos Devs e o cálculo de XP.

## 📁 Estrutura de Classes do Projeto

O projeto está organizado no pacote `br.com.dio.desafio.dominio` e contém as seguintes classes principais:

* `Main.java`: Ponto de entrada da aplicação. É aqui que os objetos são instanciados e as interações são simuladas. Cria cursos, mentorias, um bootcamp e devs, e demonstra o fluxo de inscrição e progressão.

* `Bootcamp.java`: Representa o Bootcamp. Possui um nome, uma descrição e um conjunto (`Set`) de desenvolvedores inscritos e de conteúdos disponíveis.

* `Dev.java`: Representa um participante do Bootcamp. Contém um nome e dois conjuntos de conteúdos: um para os conteúdos em que está inscrito e outro para os conteúdos que já concluiu. É responsável por gerenciar a progressão e calcular o XP total.

* `Conteudo.java`: É uma classe abstrata que serve como base para `Curso` e `Mentoria`. Define um contrato comum com um título, uma descrição e um método abstrato `calcularXp()`.

* `Curso.java`: Herda de `Conteudo` e representa um curso. Possui um atributo adicional `cargaHoraria` e implementa o cálculo de XP multiplicando a carga horária pelo `XP_PADRAO`.

* `Mentoria.java`: Herda de `Conteudo` e representa uma mentoria. Possui um atributo de data (`LocalDate`) e implementa o cálculo de XP adicionando 20 pontos ao `XP_PADRAO`.
