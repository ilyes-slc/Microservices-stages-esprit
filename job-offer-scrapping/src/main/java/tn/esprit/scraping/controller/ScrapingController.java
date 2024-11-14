package tn.esprit.scraping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.scraping.model.JobData;
import tn.esprit.scraping.service.ScrapingService;

import java.util.List;

@RestController
@RequestMapping("/scrape")
public class ScrapingController {

    @Autowired
    private ScrapingService scrapingService;

    @GetMapping("/jobs")
    public ResponseEntity<String> scrapeJobs() {
        try {
            scrapingService.scrapeJobData();
            return ResponseEntity.ok("Scraping process started successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Scraping process failed: " + e.getMessage());
        }
    }

    @GetMapping("/jobs/all")
    public ResponseEntity<List<JobData>> findAllJobs() {
        List<JobData> jobDataList = scrapingService.findAllJobs();
        if (jobDataList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jobDataList);
        }
    }
}