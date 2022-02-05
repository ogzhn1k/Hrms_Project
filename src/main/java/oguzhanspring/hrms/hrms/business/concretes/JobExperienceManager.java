package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.JobExperienceService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import oguzhanspring.hrms.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAllExperiences() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"İş tecrübeleri listelendi");
	}

	@Override
	public Result addExperience(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}

}
