package com.example.hrmsSpringBoot.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.lang.model.element.QualifiedNameable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.EmployerService;
import com.example.hrmsSpringBoot.business.abstracts.JobAdvertisementService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.ErrorDataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerService employerService;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerService employerService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerService = employerService;
	}

	@Override
	public Result closeJobAdvertisement(JobAdvertisement jobAdvertisement) {
		return new SuccessDataResult(this.employerService.closeJobAdvertisement(jobAdvertisement));
	}
	

	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(this.jobAdvertisementDao.findById(jobAdvertisement.getId())!=null) {
			return new ErrorDataResult("İş ilanı zaten mevcut!");
		}
		else {
			return new SuccessDataResult(this.employerService.addJobAdvertisement(jobAdvertisement));
		}
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.findByIsActiveTrue(), "Aktif iş ilanları listelendi!");
		}
	

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByJobDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.findByIsActiveTrueOrderByJobDeadlineDesc(), "İş ilanları listelendi!");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_Id(employerId), "İş ilanları listelendi!");
		
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		Result result = null;
		if(jobAdvertisement.getJobDeadline().isBefore(LocalDate.now())) {
			jobAdvertisement.setActive(false);
			result = new SuccessDataResult("İş ilanı artık aktif değil!");
		}
		else {
			jobAdvertisement.setActive(true);
			result = new ErrorDataResult("İş ilanı artık aktif değil!");
		}
		return result;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobPositionId(int jobPositionId) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndJobPosition_Id(jobPositionId), "İş ilanı listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCity(int cityId) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndCity_Id(cityId), "İş ilanı listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByDescription(String jobDescription) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndJobDescription(jobDescription), "İş ilanı listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByMaxSalaryOrMinSalary(int jobMaxSalary, int jobMinSalary) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndJobMaxSalaryOrJobMinSalary(jobMaxSalary, jobMinSalary), "İş ilanı listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByNumberOfJobPosition(int numberOfJobPosition) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndNumberOfJobPosition(numberOfJobPosition), "İş ilanı listelendi!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobDeadline(LocalDate jobDeadline) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueAndJobDeadline(jobDeadline), "İş ilanı listelendi!");
	}

	
	
}

	
