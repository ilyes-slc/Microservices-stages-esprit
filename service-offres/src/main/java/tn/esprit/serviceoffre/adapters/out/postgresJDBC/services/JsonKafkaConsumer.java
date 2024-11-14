package tn.esprit.serviceoffre.adapters.out.postgresJDBC.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities.JobData;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    public void consume(JobData jobData){
        LOGGER.info(String.format("Json message recieved -> %s", jobData.toString()));
    }
}
