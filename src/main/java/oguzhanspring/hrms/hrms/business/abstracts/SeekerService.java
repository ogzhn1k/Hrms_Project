package oguzhanspring.hrms.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Seeker;

public interface SeekerService{
	
	DataResult<List<Seeker>> getAllSeekers();
	
	Result addSeeker(Seeker seeker) throws NumberFormatException, RemoteException;
	
	Result isEmailExist(String email);
		
	Result isTcIdExist(String tcid);
	
}
