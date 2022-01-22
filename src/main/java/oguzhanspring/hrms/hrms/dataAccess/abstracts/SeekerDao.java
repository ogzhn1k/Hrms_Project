package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.Seeker;

public interface SeekerDao extends JpaRepository<Seeker, Integer>{
	
	List<Seeker> findByEmail(String email);
	List<Seeker> findByTcid(String tcid);
}
