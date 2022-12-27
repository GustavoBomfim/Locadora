package application;

import java.sql.*;
import java.time.LocalDate;

public class Aluguel {
    //Cliente cpf;

    public void alugarFilme(Connection connection, Date dia, Date devolucao, String cpf, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ALUGUEL (dia, devolucao, fk_cpf, fk_id) VALUES(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setDate(1, dia);
        preparedStatement.setDate(2, devolucao);


        preparedStatement.setString(3, cpf);
        preparedStatement.setInt(4, id);

        preparedStatement.execute();
        /*
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            System.out.println("O id criado foi " + id);
        }

         */

    }
}
