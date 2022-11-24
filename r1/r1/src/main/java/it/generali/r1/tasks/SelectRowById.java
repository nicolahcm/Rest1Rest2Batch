package it.generali.r1.tasks;


import java.sql.*;
import java.util.Optional;

public class SelectRowById {

    private final String SQL_SELECT = "SELECT * FROM product WHERE idproduct=?;";

    public Timestamp selectRow(int id) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products", "root", "");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Timestamp date = resultSet.getTimestamp("data_creazione");
                    return date;
                }

            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
