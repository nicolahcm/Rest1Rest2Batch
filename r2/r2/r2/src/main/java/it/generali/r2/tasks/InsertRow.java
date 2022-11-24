package it.generali.r2.tasks;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

public class InsertRow {


    private final String INSERT_SQL = "INSERT INTO product2 (data_creazione, id_origine, " +
            "data_creazione_origine) VALUES (?,?,?)";

    public int createRow(int id_origine, Timestamp data_creazione_origine) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root","");

        PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.setInt(2, id_origine);
        preparedStatement.setTimestamp(3, data_creazione_origine);

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int idProduct = rs.getInt(1);
            return idProduct;
        }


        return -1;
    }
}
