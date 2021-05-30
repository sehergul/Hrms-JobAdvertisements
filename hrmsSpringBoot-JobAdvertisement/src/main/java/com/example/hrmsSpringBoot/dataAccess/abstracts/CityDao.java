package com.example.hrmsSpringBoot.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsSpringBoot.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
