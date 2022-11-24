package it.generali.r1;

import it.generali.r1.beans.RequestR1;
import it.generali.r1.beans.ResponseMessage;
import it.generali.r1.tasks.SelectRowById;
import it.generali.r1.tasks.SendHTTPReqToR2;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Timestamp;

@SpringBootApplication
public class R1Application {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(R1Application.class, args);

//		 Task 3-4
//		SelectRowById selectRowById = new SelectRowById();
//		Timestamp date = selectRowById.selectRow(3);



	}

}
