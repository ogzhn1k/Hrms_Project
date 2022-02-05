package oguzhanspring.hrms.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	
	

}
