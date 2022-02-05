package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.SchoolService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.SchoolDao;
import oguzhanspring.hrms.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAllSchools() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi");
	}

	@Override
	public Result addSchool(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}

	

}
