package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.CityService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.CityDao;
import oguzhanspring.hrms.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{  
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAllCities() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler listelendi");
	}

	@Override
	public Result addCity(City city) {
		this.cityDao.save(city);
		
		return new SuccessResult("Şehir sisteme eklenmiştir");
	}

}
