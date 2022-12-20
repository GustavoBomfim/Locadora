package application;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/cinema?useTimeZone=true&serverTimeZone=UTC", "root", "password");

        System.out.println("Hello World!");
        System.out.println("connection successful");

        // String result = Listagem(connection);
        listagem(connection);

        /*
        Statement statement = connection.createStatement();
        statement.execute("SELECT  id, nome, genero, duracao, ator_principal, diretor FROM FILME");
        ResultSet resultSet = statement.getResultSet();

        // System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println();
            Integer id = resultSet.getInt("id");
            System.out.println("Id do filme: " + id);
            String nome = resultSet.getString("nome");
            System.out.println("Nome do filme: " + nome);
            String genero = resultSet.getString("genero");
            System.out.println("Gênero: " + genero);

            //COMO CONSULTAR A COLUNA duracao
            Time duracao = resultSet.getTime("duracao");
            System.out.println("Duração: " + duracao);

            String ator_principal = resultSet.getString("ator_principal");
            System.out.println("Ator principal: " + ator_principal);
            String diretor = resultSet.getString("diretor");
            System.out.println("Diretor: " + diretor);

            System.out.println("---------------------------------------------------------------------------");

        }

         */
        inserir(connection);

        //Receber inputs do usuário
        /*Scanner sc = new Scanner(System.in);

        System.out.print("Cadastre o nome do filme: ");
        String nome = sc.next();

        System.out.print("Cadastre o genero do filme: ");
        String genero = sc.next();

        System.out.print("Cadastre o ator principal do filme: ");
        String ator_principal = sc.next();

        System.out.print("Cadastre o diretor do filme: ");
        String diretor = sc.next();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILME (nome, genero, ator_principal, diretor) VALUES (?,?,?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, genero);
        preparedStatement.setString(3, ator_principal);
        preparedStatement.setString(4, diretor);

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }

         */




        connection.close();
    }


    public static void listagem(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SELECT  id, nome, genero, duracao, ator_principal, diretor FROM FILME");
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()){
            System.out.println();
            Integer id = resultSet.getInt("id");
            System.out.println("Id do filme: " + id);
            String nome = resultSet.getString("nome");
            System.out.println("Nome do filme: " + nome);
            String genero = resultSet.getString("genero");
            System.out.println("Gênero: " + genero);

            //COMO CONSULTAR A COLUNA duracao
            Time duracao = resultSet.getTime("duracao");
            System.out.println("Duração: " + duracao);

            String ator_principal = resultSet.getString("ator_principal");
            System.out.println("Ator principal: " + ator_principal);
            String diretor = resultSet.getString("diretor");
            System.out.println("Diretor: " + diretor);

            System.out.println("---------------------------------------------------------------------------");

        }
    }

    public static void inserir(Connection connection) throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Cadastre o nome do filme: ");
        String nome = sc.next();

        sc.next();
        System.out.print("Cadastre o genero do filme: ");
        String genero = sc.next();

        sc.next();
        System.out.print("Cadastre o ator principal do filme: ");
        String ator_principal = sc.next();

        sc.next();
        System.out.print("Cadastre o diretor do filme: ");
        String diretor = sc.next();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILME (nome, genero, ator_principal, diretor) VALUES (?,?,?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, genero);
        preparedStatement.setString(3, ator_principal);
        preparedStatement.setString(4, diretor);

        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }

    }


}
