package oguzhanspring.hrms.hrms.business.abstracts;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.City;

public interface CityService {

	DataResult<City> getAllCities();
	Result addCity(City city);
}
