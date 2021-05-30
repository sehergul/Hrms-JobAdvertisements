package com.example.hrmsSpringBoot.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	
	@Column(name = "job_min_salary")
	private int jobMinSalary;
	
	@Column(name = "job_max_salary")
	private int jobMaxSalary;
	
	@Column(name = "number_of_job_position")
	private int numberOfJobPosition;
	
	@Column(name = "job_deadline")
	private LocalDate jobDeadline;
	
	@Column(name = "job_advertisement_date")
	private LocalDate jobAdvertisementDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	@ManyToOne()
	@JoinColumn(name = "job_position_id") //Hangi kolonla iliskilendirilecek
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "company_id")
	private Employer employer;

	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	public JobAdvertisement() {
		super();
	}


	public JobAdvertisement(int id, String jobDescription, int jobMinSalary, int jobMaxSalary, int numberOfJobPosition,
			LocalDate jobDeadline, LocalDate jobAdvertisementDate, JobPosition jobPosition, Employer employer,
			City city,  boolean isActive) {
		super();
		this.id = id;
		this.jobDescription = jobDescription;
		this.jobMinSalary = jobMinSalary;
		this.jobMaxSalary = jobMaxSalary;
		this.numberOfJobPosition = numberOfJobPosition;
		this.jobDeadline = jobDeadline;
		this.jobAdvertisementDate = jobAdvertisementDate;
		this.jobPosition = jobPosition;
		this.employer = employer;
		this.city = city;
		this.isActive = isActive;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public int getJobMinSalary() {
		return jobMinSalary;
	}


	public void setJobMinSalary(int jobMinSalary) {
		this.jobMinSalary = jobMinSalary;
	}


	public int getJobMaxSalary() {
		return jobMaxSalary;
	}


	public void setJobMaxSalary(int jobMaxSalary) {
		this.jobMaxSalary = jobMaxSalary;
	}


	public int getNumberOfJobPosition() {
		return numberOfJobPosition;
	}


	public void setNumberOfJobPosition(int numberOfJobPosition) {
		this.numberOfJobPosition = numberOfJobPosition;
	}


	public LocalDate getJobDeadline() {
		return jobDeadline;
	}


	public void setJobDeadline(LocalDate jobDeadline) {
		this.jobDeadline = jobDeadline;
	}


	public LocalDate getJobAdvertisementDate() {
		return jobAdvertisementDate;
	}


	public void setJobAdvertisementDate(LocalDate jobAdvertisementDate) {
		this.jobAdvertisementDate = jobAdvertisementDate;
	}


	public JobPosition getJobPosition() {
		return jobPosition;
	}


	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}


	public Employer getEmployer() {
		return employer;
	}


	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	
	public City getCity() {
		return city;
	}

	
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
	
}
