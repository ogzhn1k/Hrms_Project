package oguzhanspring.hrms.hrms.core.utilities.adapters.abstracts;

import java.rmi.RemoteException;

import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Seeker;

public interface MernisCheckService {
	
	Result checkBelongsToTc(Seeker seeker) throws NumberFormatException, RemoteException;
}
