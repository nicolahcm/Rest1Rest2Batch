package it.generali.r2.controllers;


import it.generali.r2.beans.RequestR1;
import it.generali.r2.beans.ResponseMessage;
import it.generali.r2.tasks.InsertRow;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/update-table2")
public class CommWithR1 {


    @PostMapping
    public ResponseMessage insert(@RequestBody RequestR1 input) throws SQLException, InterruptedException {
        System.out.println("input is " + input);

        // In postman send a request like {
        //    "id_origine": 5,
        //    "data_creazione_origine": "2007-11-23T10:10:10.02"
        //}

//        InsertRow insertRow = new InsertRow();
//		int createdId = insertRow.createRow(input.getId_origine(), input.getData_creazione_origine());
        String fakeStatus = "failed";
        String fakeCause = "db error";
        //ResponseMessage responseMessage = new ResponseMessage(fakeStatus, fakeCause, createdId);
        ResponseMessage responseMessage = new ResponseMessage(fakeStatus, fakeCause, 21);

        Thread.sleep(30000);
        return responseMessage;
    }
}
