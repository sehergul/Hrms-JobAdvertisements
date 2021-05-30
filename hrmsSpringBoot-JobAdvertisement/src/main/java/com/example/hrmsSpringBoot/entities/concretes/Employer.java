package com.example.hrmsSpringBoot.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Employer extends User{
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	public Employer() {
		super();
	}

	

	public Employer(int id, String companyName, String website, String phone,
			List<JobAdvertisement> jobAdvertisements) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
		this.jobAdvertisements = jobAdvertisements;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<JobAdvertisement> getJobAdvertisements() {
		return jobAdvertisements;
	}


	public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
		this.jobAdvertisements = jobAdvertisements;
	}
	
	
	
	
	
}