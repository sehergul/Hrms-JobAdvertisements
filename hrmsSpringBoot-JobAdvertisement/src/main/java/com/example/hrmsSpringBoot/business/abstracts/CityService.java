package com.example.hrmsSpringBoot.business.abstracts;

import java.util.List;

import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
