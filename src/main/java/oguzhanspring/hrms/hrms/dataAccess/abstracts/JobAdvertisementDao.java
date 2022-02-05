package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import oguzhanspring.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> findAllByIsActive(boolean isActive);
	
	List<JobAdvertisement> findAllByIsActiveTrueOrderByLastApplicationAsc();
	
	List<JobAdvertisement> findAllByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	
	@Modifying
	@Query("Update JobAdvertisement ja set ja.isActive =: false where employer.userId =: employer_id")
	void closeJobAdvertisement(int employer_id);
	
}
