package tn.esprit.scraping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tn.esprit.scraping.model.JobData;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "jobdatatopic";

    @Autowired
    private KafkaTemplate<String, JobData> kafkaTemplate;

    public void sendMessage(JobData jobData) {
        kafkaTemplate.send(TOPIC, jobData);
    }
}