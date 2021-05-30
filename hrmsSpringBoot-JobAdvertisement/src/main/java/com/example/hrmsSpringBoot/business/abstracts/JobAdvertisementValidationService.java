package com.example.hrmsSpringBoot.business.abstracts;

import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;

public interface JobAdvertisementValidationService {
	boolean checkCompanyName(JobAdvertisement jobAdvertisement);
	boolean checkJobPosition(JobAdvertisement jobAdvertisement);
	boolean checkNumberOfJobPosition(JobAdvertisement jobAdvertisement);
	boolean checkDate(JobAdvertisement jobAdvertisement);
	boolean checkDeadline(JobAdvertisement jobAdvertisement);
	boolean checkDescription(JobAdvertisement jobAdvertisement);
	boolean checkCity(JobAdvertisement jobAdvertisement);
	boolean totalCheck(JobAdvertisement jobAdvertisement);
}
