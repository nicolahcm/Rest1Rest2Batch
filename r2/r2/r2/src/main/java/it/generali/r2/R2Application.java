package it.generali.r2;

import it.generali.r2.tasks.InsertRow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.sql.Timestamp;

@SpringBootApplication
public class R2Application {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(R2Application.class, args);


	}

}
