package com.example.hrmsSpringBoot.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findByIsActiveTrueAndJobPosition_Id(int jobPositionId);
	  
	List<JobAdvertisement> findByIsActiveTrueAndCity_Id(int cityId);
	  
	List<JobAdvertisement> findByIsActiveTrueAndJobDescription(String jobDescription);
	  
	List<JobAdvertisement> findByIsActiveTrueAndJobMaxSalaryOrJobMinSalary(int maxSalary, int minSalary);
	  
	List<JobAdvertisement> findByIsActiveTrueAndNumberOfJobPosition(int numberOfJobPosition);
	  
	List<JobAdvertisement> findByIsActiveTrueAndJobDeadline(LocalDate jobDeadline);
	 
	List<JobAdvertisement> findByIsActiveTrue();
	
	List<JobAdvertisement> findByIsActiveTrueOrderByJobDeadlineDesc();
	
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int employerId);
	

	
}
