package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.JobService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.ErrorResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.JobDao;
import oguzhanspring.hrms.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}
	
	
	@Override
	public DataResult<List<Job>> getAllJobs() {
		
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Pozisyonlar Listelendi !!!");
	}

	@Override
	public Result addJob(Job job) {
				
		if(this.jobDao.findByJobName(job.getJobName()) != null ) {
			
			return new ErrorResult("Pozisyon zaten mevcut");
		}
		
		this.jobDao.saveAndFlush(job);
		return new SuccessResult("Pozisyon Eklendi");
			
	}

}
