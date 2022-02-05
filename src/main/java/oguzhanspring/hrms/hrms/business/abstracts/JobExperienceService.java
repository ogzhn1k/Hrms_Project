package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<List<JobExperience>> getAllExperiences();
	
	Result addExperience(JobExperience jobExperience);
}
