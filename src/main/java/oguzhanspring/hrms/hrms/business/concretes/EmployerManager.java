package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.EmployerService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.ErrorResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts.EmailVerifyService;
import oguzhanspring.hrms.hrms.core.utilities.verifications.abstracts.HrmsConfirmService;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.EmployerDao;
import oguzhanspring.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	EmailVerifyService eMailVerifyService;
	HrmsConfirmService hrmsConfirmService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerifyService eMailVerifyService,HrmsConfirmService hrmsConfirmService) {
		super();
		this.employerDao = employerDao;
		this.eMailVerifyService = eMailVerifyService;
		this.hrmsConfirmService = hrmsConfirmService;
	}

	@Override
	public DataResult<List<Employer>> getAllEmployers() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}
	
	public Result isEmailExist(String eMail) {
		
		if(this.employerDao.getByEmail(eMail) != null) {
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}
	

	@Override
	public Result addEmployer(Employer employer) {
		
		if(!this.isEmailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Email adresi zaten mevcut");
		}
		
		if(!this.eMailVerifyService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Email doğrulama işlemi başarısız");
		}
		
		if(!this.hrmsConfirmService.confirmRegistration(employer).isSuccess()) {
			return new ErrorResult("İş veren hrms personeli tarafından onaylanmamıştır");
		}
		
		
		this.employerDao.save(employer);
		return new SuccessResult("İş veren kişi sisteme eklenmiştir");
		
	}


}
