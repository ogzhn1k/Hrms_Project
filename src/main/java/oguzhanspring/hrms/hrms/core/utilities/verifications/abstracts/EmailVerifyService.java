package oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts;

import oguzhanspring.hrms.hrms.core.utilities.results.Result;

public interface EmailVerifyService {
	
	Result verifyEmail(String email);
}
