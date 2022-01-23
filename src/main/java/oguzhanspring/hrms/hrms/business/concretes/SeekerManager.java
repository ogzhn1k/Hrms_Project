package oguzhanspring.hrms.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.SeekerService;
import oguzhanspring.hrms.hrms.core.utilities.adapters.abstracts.MernisCheckService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.ErrorResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts.EmailVerifyService;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.SeekerDao;
import oguzhanspring.hrms.hrms.entities.concretes.Seeker;

@Service
public class SeekerManager implements SeekerService{

	SeekerDao seekerDao;
	MernisCheckService mernisCheckService;
	EmailVerifyService eMailVerifyService;
	
	@Autowired
	public SeekerManager(SeekerDao seekerDao,MernisCheckService mernisCheckService,EmailVerifyService eMailVerifyService) {
		super();
		this.seekerDao = seekerDao;
		this.mernisCheckService = mernisCheckService;
		this.eMailVerifyService = eMailVerifyService;
	}
	

	@Override
	public DataResult<List<Seeker>> getAllSeekers() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll(),"İş arayanlar listelendi");
	}
	
	@Override
	public Result isEmailExist(String email) {
		
		if(this.seekerDao.getByEmail(email) != null) {
			return new ErrorResult();
		}

		return new SuccessResult();
	}


	@Override
	public Result isTcIdExist(String tcid) {
		
		if(this.seekerDao.getByTcid(tcid) != null) {
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}
	
	@Override
	public Result addSeeker(Seeker seeker) throws NumberFormatException, RemoteException {
		
		if(!this.isTcIdExist(seeker.getTcid()).isSuccess() || !this.isEmailExist(seeker.getEmail()).isSuccess()) {
			return new ErrorResult("Hata --> İş arayan ekleme işlemi başarısız!!!");
		}
		
		
		/*if(!this.mernisCheckService.checkBelongsToTc(seeker).isSuccess()) {
			return new ErrorResult("Mernis doğrulaması başarısız");
		}*/
		
		this.seekerDao.saveAndFlush(seeker);
		return new SuccessResult("İş arayan kişi sisteme eklenmiştir");
		
	}

}
