package oguzhanspring.hrms.hrms.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts.EmailVerifyService;

@Service
public class EmailVerifyManager implements EmailVerifyService{

	@Override
	public Result verifyEmail(String email) {
		
		return new SuccessResult();
	}

}
