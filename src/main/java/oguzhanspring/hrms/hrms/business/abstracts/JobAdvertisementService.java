package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.JobAdvertisement;
import oguzhanspring.hrms.hrms.entities.dtos.JobActiveDto;
import oguzhanspring.hrms.hrms.entities.dtos.JobAdDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAllAdvertisements();
	
	Result addJobAdvertisement(JobAdDto jobAdDto);
	
	DataResult<List<JobActiveDto>> findAllByIsActive(boolean isActive);
	
	DataResult<List<JobActiveDto>> findByIsActiveTrueOrderByLastApplicationAsc();
	
	DataResult<List<JobActiveDto>> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
	
	void closeJobAdvertisement(int employer_id);

}
