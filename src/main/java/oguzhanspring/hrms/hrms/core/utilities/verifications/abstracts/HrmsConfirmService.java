package oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts;

import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Employer;

public interface HrmsConfirmService {
	
	Result confirmRegistration(Employer employer);
}
