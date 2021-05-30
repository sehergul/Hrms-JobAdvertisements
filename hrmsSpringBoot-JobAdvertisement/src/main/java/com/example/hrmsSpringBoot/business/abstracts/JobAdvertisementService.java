package com.example.hrmsSpringBoot.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result closeJobAdvertisement(JobAdvertisement jobAdvertisement); 
	  
	Result add (JobAdvertisement jobAdvertisement);  
	
	DataResult<List<JobAdvertisement>> getByJobPositionId(int jobPositionId);
	  
	DataResult<List<JobAdvertisement>> getByCity(int cityId);
	  
	DataResult<List<JobAdvertisement>> getByDescription(String jobDescription);
	  
	DataResult<List<JobAdvertisement>> getByMaxSalaryOrMinSalary(int jobMaxSalary, int jobMinSalary);
	  
	DataResult<List<JobAdvertisement>> getByNumberOfJobPosition(int numberOfJobPosition);
	  
	DataResult<List<JobAdvertisement>> getByJobDeadline(LocalDate jobDeadline);
	 
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByJobDeadlineDesc();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueByEmployerId(int employerId);

	Result update(JobAdvertisement jobAdvertisement);
}
