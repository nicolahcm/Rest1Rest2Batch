package it.generali.r1.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import it.generali.r1.beans.RequestR1;
import it.generali.r1.beans.ResponseMessage;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SendHTTPReqToR2 {
//    private final int TIMEOUT = 20;  Come fare il timeout?


    private final String urlBase = "http://localhost:8011/update-table2";

    private static final Logger logger = LoggerFactory.getLogger(SendHTTPReqToR2.class);


    public ResponseMessage sendPostRequest(RequestR1 requestR1, RestTemplate rest) {

        long TIMEOUT = 20000;

//        RestTemplate rest = new RestTemplate();
        return rest.postForObject(urlBase, requestR1, ResponseMessage.class);


//                .setConnectTimeout(Duration.of(TIMEOUT, ChronoUnit.MILLIS))
//                .setReadTimeout(Duration.of(TIMEOUT,ChronoUnit.MILLIS))
//                .build();;

//        logger.debug("Messaggio Di logging");
//        logger.info("Messaggio con info");
//        logger.error("Messaggio con Error");

    }
}
