package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAllEmployers();
	
	Result addEmployer(Employer employer);
}
