package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAllAdvertisements();
	
	Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> findByIsActiveIs(boolean isActive);
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByLastApplicationAsc();
	
	DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);

}
