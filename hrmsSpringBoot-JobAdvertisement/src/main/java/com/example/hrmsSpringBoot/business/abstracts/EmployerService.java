package com.example.hrmsSpringBoot.business.abstracts;

import java.util.List;

import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.Employer;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;


public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	Result register(Employer employer);
	Result addJobAdvertisement (JobAdvertisement jobAdvertisement);
	Result closeJobAdvertisement(JobAdvertisement jobAdvertisement);
}
