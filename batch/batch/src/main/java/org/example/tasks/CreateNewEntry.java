package org.example.tasks;


import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

public class CreateNewEntry {

    private final String SQL_INSERT = "INSERT INTO product (data_creazione) VALUES (?)";

    public int createRow() throws IOException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products", "root", "");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.executeUpdate();

                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    int idProduct = rs.getInt(1);
                    return idProduct;
                }


            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // If somehow there was an error, it returns -1,
        // Instead of the id of the newly created row.
        return -1;
    }
}
