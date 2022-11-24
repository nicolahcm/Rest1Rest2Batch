package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.beans.ResponseMessage;
import org.example.tasks.CreateNewEntry;
import org.example.tasks.StartHttpToR1;
import org.json.JSONObject;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

//      Task 1
        CreateNewEntry createNewEntry = new CreateNewEntry();
        int createdId = createNewEntry.createRow();
        System.out.println("newly created id is " + createdId);

//      Task 2 and 10
        StartHttpToR1 startHttpToR1 = new StartHttpToR1();
        System.out.println("sending get request...");

        JSONObject jsonObject = startHttpToR1.sendGet(createdId);
        long id = jsonObject.getLong("id");
        String cause = jsonObject.getString("cause");
        String status = jsonObject.getString("successOrFailure");
        ResponseMessage responseMessage = new ResponseMessage(status, cause, id);

        // The logic of the error and message will be written down in the description column of T1 by R1.

        // Left To Write in a log File.
        logger.info("Response message is " + responseMessage);

    }
}