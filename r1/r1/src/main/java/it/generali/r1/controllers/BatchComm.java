package it.generali.r1.controllers;


import it.generali.r1.beans.RequestR1;
import it.generali.r1.beans.ResponseMessage;
import it.generali.r1.tasks.SelectRowById;
import it.generali.r1.tasks.SendHTTPReqToR2;
import it.generali.r1.tasks.UpdateRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/table1-product")
public class BatchComm {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseMessage writeToT2(@PathVariable int id) throws InterruptedException, SQLException, IOException {

        System.out.println("request received... With id " + id);
        // Receives the id... Queries the db with selectRowById
//        SelectRowById selectRowById = new SelectRowById();
//        Timestamp date = selectRowById.selectRow(id);
//        System.out.println("the new entry with id " + id + " has been inserted at time " + date);

        // Tasks 5,8 to add here
//        RequestR1 requestR1 = new RequestR1(id, date);
        RequestR1 requestR1 = new RequestR1(23, new Timestamp(133));
        SendHTTPReqToR2 sendHTTPReqToR2 = new SendHTTPReqToR2();
        ResponseMessage response = sendHTTPReqToR2.sendPostRequest(requestR1, restTemplate);
        System.out.println("response is " + response);

        // I use the Thread.sleep per ora al posto della richiesta a R2.
        // Task 9 here
//        UpdateRow updateRow = new UpdateRow();
//        updateRow.updateById(id, response);

        return response;
    }
}
