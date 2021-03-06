package hrmsfullBackend.hrms.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.CityService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;

import hrmsfullBackend.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getCities")
	public DataResult<List<City>> getCities(){
		return this.cityService.getCities();
	}
}
