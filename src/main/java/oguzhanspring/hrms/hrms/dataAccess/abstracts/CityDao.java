package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	
	City getByCityName(String cityName);

}
