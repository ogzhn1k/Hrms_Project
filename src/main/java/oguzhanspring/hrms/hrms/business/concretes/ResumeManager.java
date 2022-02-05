package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.ResumeService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.ResumeDao;
import oguzhanspring.hrms.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAllResumes() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"CV ler listelendi");
	}

	@Override
	public Result addResume(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("CV eklendi");
	}

}
