package it.generali.r1.tasks;

import it.generali.r1.beans.ResponseMessage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;

public class UpdateRow {

    private final String UPDATE_SQL = "UPDATE product SET elaborato='Y', description=?, " +
            "data_elaborazione=? WHERE idproduct=?;";

    public void updateById(int id, ResponseMessage responseMessage) throws IOException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root","");

        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_SQL);
        preparedStatement.setString(1, responseMessage.toString());
        preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.setInt(3, id);

        preparedStatement.executeUpdate();

    }
}
