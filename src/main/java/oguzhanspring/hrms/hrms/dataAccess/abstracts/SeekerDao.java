package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.Seeker;

public interface SeekerDao extends JpaRepository<Seeker, Integer>{
	
	Seeker getByEmail(String email);
	Seeker getByTcid(String tcid);
}
