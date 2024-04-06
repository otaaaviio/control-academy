Trabalho 1:

    Estrutura do projeto:
        Utilizei o padrão de projeto "Spring Boot", com as pastas: controller, dto, entity, factory, repository, service e
        tests.

    Dependencias:
        Utilizei alguns plugins a mais do que o Spring Boot para implementar todas requisições do trabalho.

    Banco de dados:
        Utilizei o PostgreSQL como banco de dados, onde a conexão é feita através do arquivo "application.properties",
        esse foi criado o Docker para facil execução do projeto, a criação das tabelas é feita através do hibernate.
        O banco contém todas as tabelas necessárias para guardar os dados especificados no trabalho, incluindo os não
        obrigatórios. Também utilizei o banco de dados H2 para a realização dos testes, para fim de não alterar os dados
        do banco de dados principal.

    Tabelas do banco de dados:
        - credit_cards
        - exercise_muscles
        - exercise_weight_history
        - exercises
        - muscles
        - plan_types
        - plans
        - training_exercises
        - training_users
        - trainings
        - users
    Foi utilizado a terceira forma normal para a modelagem do banco de dados.

    Tests:
        Contém testes para todos controller e todos end-points, os testes são realizados utilizando o banco de dados H2,
        onde é feito a criação de objetos falsos para a realização dos testes, os testes são realizados utilizando o
        JUnit e o Mockito.

    Entity:
        Contém as classes que representam as entidades do banco de dados, onde cada classe representa uma tabela do banco
        de dados, as classes contém os atributos necessários para a representação dos dados, além de getters e setters.

    Dto:
        Contém as classes que representam os objetos de transferência de dados, onde cada classe representa um objeto que
        será utilizado para a transferência de dados para a API, as classes contém os atributos necessários
        para a representação dos dados, além de getters e setters, além de validações para os dados de entrada.

    Repository:
        Contém as interfaces que estendem a interface "JpaRepository" do Spring Data JPA, onde cada interface representa
        uma tabela do banco de dados, as interfaces contém métodos para a realização de operações no banco de dados,
        como inserção, atualização, remoção e busca de dados. Também contém métodos para a busca de dados específicos.

    Service:
        Contém as classes que implementam a lógica de negócio, onde cada classe representa uma tabela do banco de dados,
        as classes contém métodos para a realização de operações no banco de dados, como inserção, atualização, remoção
        e busca de dados. Os services utilizam os repositories para a realização das operações no banco de dados.
        Existe uma classe "BaseService" que contém métodos genéricos para a realização de operações no banco de dados,
        alguns services estendem essa classe para a utilização dos métodos.

    Controller:
        Contém as classes que implementam os endpoints da API, onde cada classe representa um endpoint, as classes contém
        métodos para a realização de operações no banco de dados, como inserção, atualização, remoção e busca de dados.
        Os controllers utilizam os services para a realização das operações no banco de dados.

    Factory:
        Contém as classes que implementam a criação de objetos, contém métodos para criação de dto e entity, utilizando o
        plugin Faker. São utilizados nos testes para criação de objetos falsos e unicos.

    Padrão de código:
        Utilizei o padrão de código "Google Java Style", onde o código é formatado de acordo com o padrão de código
        definido pelo Google, para a formatação do código utilizei o plugin "google-java-format" do IntelliJ IDEA.
        Além disso, defini como padrão a linguagem inglesa para a escrita do código(classes, métodos, variáveis, etc).

    Execução:
        Para executar o projeto, basta instalar as dependencias do Maven, dessa maneira já é possivel executar os testes,
        para executar o projeto basta criar um banco de dados e configurar o arquivo "application.properties" com as
        informações do banco de dados, após isso basta executar a classe "Application.java". É possivel utilizar o Postman
        para realização de testes nos endpoints da API.

    GitHub:
        O projeto está disponível no GitHub, no seguinte link:
        https://github.com/otaaaviio/control-academy

    Considerações finais:
        O projeto foi desenvolvido utilizando o Spring Boot, onde foi implementado todas as requisições do trabalho.
        O projeto é simples e objetivo, não extrapolando o que foi pedido no trabalho, porém, é possivel adicionar mais
        funcionalidades ao projeto, como melhoria nos testes, adição de retorno de endpoints com dto's. Como o objetivo
        do trabalho é em relação a API, não foi feito uma interface gráfica para a utilização da API, porém, é possivel
        utilizar o Postman para a realização de testes nos endpoints da API ou até mesmo os testes.
        Além disso, um dos objetivos do trabalho é a Prograamação Orientada a Objetos, onde foi utilizado o conceito de
        POO para a implementação do projeto.