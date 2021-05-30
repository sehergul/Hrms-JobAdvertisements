package com.example.hrmsSpringBoot.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "city_name")
	private int cityName;
	
	@OneToMany(mappedBy = "city")
	private List<JobAdvertisement> jobAdvertisements;

	public City() {
		super();
	}

	public City(int id, int cityName, List<JobAdvertisement> jobAdvertisements) {
		super();
		this.id= id;
		this.cityName = cityName;
		this.jobAdvertisements = jobAdvertisements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id= id;
	}

	public int getCityName() {
		return cityName;
	}

	public void setCityName(int cityName) {
		this.cityName = cityName;
	}

	public List<JobAdvertisement> getJobAdvertisements() {
		return jobAdvertisements;
	}

	public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
		this.jobAdvertisements = jobAdvertisements;
	}

	
}
