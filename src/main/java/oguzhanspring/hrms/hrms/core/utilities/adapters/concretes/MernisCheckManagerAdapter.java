package oguzhanspring.hrms.hrms.core.utilities.adapters.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import oguzhanspring.hrms.hrms.core.utilities.results.ErrorResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.entities.concretes.Seeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManagerAdapter implements MernisCheckService{

	@Override
	public Result checkBelongsToTc(Seeker seeker) {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		
		boolean result;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(seeker.getTcid()), 
					                                              seeker.getName().toUpperCase(new Locale("tr","TR")),
					                                              seeker.getSurname().toUpperCase(new Locale("tr","TR")),
					                                              seeker.getBirthYear());
			
			if(!result) 
				return new ErrorResult();
						
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SuccessResult();

		
	}

}
