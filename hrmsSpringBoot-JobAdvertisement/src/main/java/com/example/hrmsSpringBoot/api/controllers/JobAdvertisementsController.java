package com.example.hrmsSpringBoot.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmsSpringBoot.business.abstracts.EmployerService;
import com.example.hrmsSpringBoot.business.abstracts.JobAdvertisementService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job_adversitements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	private EmployerService employerService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService,
			EmployerService employerService) {
		this.jobAdvertisementService = jobAdvertisementService;
		this.employerService = employerService;
	}

	  
	@PostMapping("/addJobAdvertisement")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.employerService.addJobAdvertisement(jobAdvertisement);
	}
	
	@PutMapping("/closeJobAdvertisement")
	public Result closeJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.employerService.closeJobAdvertisement(jobAdvertisement);
	}
	
	  @GetMapping("/getByJobPositionId") 
	  public DataResult<List<JobAdvertisement>> getByJobPositionId(@RequestParam("jobPosition") int jobPositionId) {
		  return this.jobAdvertisementService.getByJobPositionId(jobPositionId); }
	  
	  
	  @GetMapping("/getByCity") 
	  public DataResult<List<JobAdvertisement>> getByCity(@RequestParam("city") int cityId) { 
		  return this.jobAdvertisementService.getByCity(cityId); }
	  
	  
	  @GetMapping("/getByDescription") 
	  public DataResult<List<JobAdvertisement>>getByDescription(@RequestParam("jobDescription") String jobDescription) { 
		  return this.jobAdvertisementService.getByDescription(jobDescription); }
	  
	  
	  @GetMapping("/getByNumberOfJobPosition") 
	  public DataResult<List<JobAdvertisement>>getByNumberOfJobPosition(@RequestParam("numberOfJobPosition") int numberOfJobPosition) { 
		  return this.jobAdvertisementService.getByNumberOfJobPosition(numberOfJobPosition); }
	  
	  
	  @GetMapping("/getByJobDeadline") 
	  public DataResult<List<JobAdvertisement>> getByJobDeadline(@RequestParam("jobDeadline") LocalDate jobDeadline) { 
		  return this.jobAdvertisementService.getByJobDeadline(jobDeadline); }
	  
	  
	  @GetMapping("/getByMaxSalaryOrMinSalary") 
	  public DataResult<List<JobAdvertisement>> getByMaxSalaryOrMinSalary(@RequestParam("jobMaxSalary") int maxSalary, @RequestParam("jobMinSalary") int minSalary) { 
		  return  this.jobAdvertisementService.getByMaxSalaryOrMinSalary(maxSalary, minSalary);
	 } 
	
	@GetMapping("/findByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> findIsByActiveTrue() {
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("/findByIsActiveTrueOrderByNameDesc")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByJobDeadlineDesc() {
		return this.jobAdvertisementService.findByIsActiveTrueOrderByJobDeadlineDesc();
	}


	@GetMapping("/findByIsActiveTrueByEmployerId")
	public DataResult<List<JobAdvertisement>>  findByIsActiveTrueByEmployerId(@RequestParam("employer") int employerId){
		return this.jobAdvertisementService.findByIsActiveTrueByEmployerId(employerId);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody JobAdvertisement advertisement) {
		return this.jobAdvertisementService.update(advertisement);
	}

}
