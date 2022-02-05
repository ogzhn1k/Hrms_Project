package oguzhanspring.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhanspring.hrms.hrms.business.abstracts.CityService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@RequestMapping("/getall")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAllCities();
	}
	
	@PostMapping("/addCity")
	public Result addCity(@RequestBody City city) {
		return this.cityService.addCity(city);
	}
	
}
