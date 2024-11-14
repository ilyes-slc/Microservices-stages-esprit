package tn.esprit.scraping.service;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.scraping.kafka.JsonKafkaProducer;
import tn.esprit.scraping.model.JobData;
import tn.esprit.scraping.repository.JobDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScrapingService {


    private JsonKafkaProducer kafkaProducer;

    public ScrapingService(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    private final Logger logger = LoggerFactory.getLogger(ScrapingService.class);


    @Autowired
    private WebDriver webDriver;

    @Autowired
    private JobDataRepository jobDataRepository;

    public List<JobData> findAllJobs() {
        return jobDataRepository.findAll();
    }

    public void scrapeJobData() {
        try {
            login();
            List<String> links = navigateAndGetLinks();
            List<JobData> jobDataList = visitLinksAndExtractData(links);

            for (JobData job : jobDataList) {
                Optional<JobData> existingJob = jobDataRepository.findByJobTitleAndCompanyNameAndLocation(job.getJobTitle(), job.getCompanyName(), job.getLocation());

                if (!existingJob.isPresent()) {
                    kafkaProducer.sendMessage(job);
                    jobDataRepository.save(job);
                    logger.info("Added new job to the database: {} at {}", job.getJobTitle(), job.getCompanyName());
                } else {
                    logger.info("Job already exists in the database: {} at {}", job.getJobTitle(), job.getCompanyName());
                }
            }
        } catch (InterruptedException e) {
            logger.error("Scraping interrupted: ", e);
        }
    }

    private List<JobData> visitLinksAndExtractData(List<String> links) throws InterruptedException {
        List<JobData> jobDataList = new ArrayList<>();
        for (String link : links) {
            try {
                webDriver.get(link);
                Thread.sleep(2000); // Wait for page to load, though WebDriverWait is recommended

                JobData jobData = new JobData();
                // Replace these with actual data extraction logic based on the webpage's structure
                try {
                    String jobTitle = webDriver.findElement(By.tagName("h1")).getText();
                    jobData.setJobTitle(jobTitle);

                    String companyName = webDriver.findElement(By.id("profile-info")).findElement(By.tagName("p")).getText();
                    jobData.setCompanyName(companyName);

                    // Assuming 'infos' is a container of job-related info, and it has multiple blocks
                    List<WebElement> infos = webDriver.findElements(By.id("infos"));
                    for (WebElement info : infos) {
                        try {
                            List<WebElement> elements = info.findElements(By.className("mt-2"));
                            if (elements.size() >= 2) {
                                String location = elements.get(0).findElement(By.tagName("p")).getText();
                                String workMethod = elements.get(1).findElement(By.tagName("a")).getText();
                                jobData.setLocation(location);
                                jobData.setMethod(workMethod);
                            }
                        } catch (Exception e) {
                            System.out.println("Exception while processing info block: " + e.getMessage());
                        }
                    }

                    String jobDescription = webDriver.findElement(By.id("description")).getText();
                    jobData.setJobDescription(jobDescription);

                    jobDataList.add(jobData);
                } catch (Exception e) {
                    System.out.println("Exception while extracting job data: " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("Exception occurred while visiting link: " + link + ", " + e.getMessage());
            }
        }
        return jobDataList;
    }


    private List<String> navigateAndGetLinks() throws InterruptedException {
        webDriver.get("https://fabskill.com/candidate/search");
        Thread.sleep(3000);

        List<WebElement> jobsBlock = webDriver.findElements(By.className("card-body"));
        List<String> links = new ArrayList<>();
        for (WebElement job : jobsBlock) {
            try {
                WebElement firstATag = job.findElement(By.tagName("a"));
                String href = firstATag.getAttribute("href");
                links.add(href);
            } catch (NoSuchElementException e) {
                System.out.println("Element not found for job: " + job.getText());
            }
        }
        return links;
    }

    private void login() throws InterruptedException {
        webDriver.get("https://fabskill.com/candidate/login");
        // Wait for the page to load
        Thread.sleep(2000); // Use WebDriverWait instead for better practice
        // Assuming user credentials are first and second lines of the file respectively
        String userName = "feryel.jawedi@esprit.tn"; // Replace with actual username or read from a config
        String password = "Azerty123"; // Replace with actual password or read from a config

        webDriver.findElement(By.xpath("/html/body/app-root/horizontal-layout/div[2]/content/div/app-authentication/div/app-auth-enter-email/div/div/div/div/form/div[1]/input")).sendKeys(userName);
        WebElement element = webDriver.findElement(By.xpath("/html/body/app-root/horizontal-layout/div[2]/content/div/app-authentication/div/app-auth-enter-email/div/div/div/div/form/div[2]/button"));

        // Using JavascriptExecutor to click on the element
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
        Thread.sleep(3000); // Again, using WebDriverWait is recommended
        webDriver.findElement(By.xpath("/html/body/app-root/horizontal-layout/div[2]/content/div/app-authentication/div/app-auth-enter-password/div/div/div/div/form/div/div[2]/input")).sendKeys(password);
        WebElement passwordSubmitButton = webDriver.findElement(By.xpath("/html/body/app-root/horizontal-layout/div[2]/content/div/app-authentication/div/app-auth-enter-password/div/div/div/div/form/div/div[3]/button"));

// Use JavascriptExecutor to click on the password submit button
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", passwordSubmitButton);
    }



}
