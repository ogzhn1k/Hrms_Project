package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> findByIsActiveIs(boolean isActive);
	
	List<JobAdvertisement> findByIsActiveTrueOrderByLastApplicationAsc();
	
	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
}
