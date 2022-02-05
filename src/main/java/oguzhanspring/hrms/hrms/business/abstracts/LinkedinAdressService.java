package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.LinkedinAdress;

public interface LinkedinAdressService {

	DataResult<List<LinkedinAdress>> getAllLinkedinAdresses();
	
	Result addLinkedinAdress(LinkedinAdress linkedinAdress);
	
}
