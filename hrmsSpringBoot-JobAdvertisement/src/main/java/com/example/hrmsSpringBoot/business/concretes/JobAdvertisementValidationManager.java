package com.example.hrmsSpringBoot.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.JobAdvertisementValidationService;
import com.example.hrmsSpringBoot.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementValidationManager implements JobAdvertisementValidationService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementValidationManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public boolean checkCompanyName(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getEmployer()!=null)
			return true;
		else {
			System.out.println("Şirket adı bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkJobPosition(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getJobPosition()!=null)
			return true;
		else {
			System.out.println("İş pozisyonu adı bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkNumberOfJobPosition(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getNumberOfJobPosition()!=0)
			return true;
		else {
			System.out.println("Açık pozisyon adedi bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkDate(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getJobAdvertisementDate()!=null)
			return true;
		else {
			System.out.println("Yayın tarihi bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkDeadline(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getJobDeadline()!=null)
			return true;
		else {
			System.out.println("Son başvuru tarihi bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkDescription(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getJobDescription()!=null)
			return true;
		else {
			System.out.println("İş tanımı bilgisi zorunludur!");
			return false;
		}
	}

	@Override
	public boolean checkCity(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getCity()!=null)
			return true;
		else {
			System.out.println("Şehir bilgisi zorunludur!");
			return false;
		}
	}
	
	@Override
	public boolean totalCheck(JobAdvertisement jobAdvertisement) {
		if(checkCity(jobAdvertisement)==true && checkCompanyName(jobAdvertisement)==true
				&& checkDate(jobAdvertisement)==true && checkDeadline(jobAdvertisement)==true
				&& checkDescription(jobAdvertisement)==true && checkJobPosition(jobAdvertisement)==true
				&& checkNumberOfJobPosition(jobAdvertisement)==true)
			return true;
		else
			return false;
	}
	

}
