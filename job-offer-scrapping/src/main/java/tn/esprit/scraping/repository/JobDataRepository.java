package tn.esprit.scraping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.scraping.model.JobData;

import java.util.Optional;

@Repository
public interface JobDataRepository extends JpaRepository<JobData, Long> {
    Optional<JobData> findByJobTitleAndCompanyNameAndLocation(String jobTitle, String companyName, String location);

}