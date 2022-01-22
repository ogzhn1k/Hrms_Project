package oguzhanspring.hrms.hrms.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts.HrmsConfirmService;
import oguzhanspring.hrms.hrms.entities.concretes.Employer;

@Service
public class HrmsConfirmManager implements HrmsConfirmService{

	@Override
	public Result confirmRegistration(Employer employer) {
		
		return new SuccessResult();
	}

}
