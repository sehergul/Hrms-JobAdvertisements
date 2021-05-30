package com.example.hrmsSpringBoot.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsSpringBoot.business.abstracts.CityService;
import com.example.hrmsSpringBoot.core.utilities.results.DataResult;
import com.example.hrmsSpringBoot.core.utilities.results.Result;
import com.example.hrmsSpringBoot.core.utilities.results.SuccessDataResult;
import com.example.hrmsSpringBoot.dataAccess.abstracts.CityDao;
import com.example.hrmsSpringBoot.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>
		(this.cityDao.findAll(), "Şehirler listelendi!");
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessDataResult("Şehir eklendi!");
		
	}
	
}
