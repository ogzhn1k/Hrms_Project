package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.LinkedinAdressService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.LinkedinAdressDao;
import oguzhanspring.hrms.hrms.entities.concretes.LinkedinAdress;

@Service
public class LinkedinAdressManager implements LinkedinAdressService{
	
	private LinkedinAdressDao linkedinAdressDao;

	@Autowired
	public LinkedinAdressManager(LinkedinAdressDao linkedinAdressDao) {
		super();
		this.linkedinAdressDao = linkedinAdressDao;
	}

	@Override
	public DataResult<List<LinkedinAdress>> getAllLinkedinAdresses() {
		return new SuccessDataResult<List<LinkedinAdress>>(this.linkedinAdressDao.findAll(),"Linkedin adresleri listelendi");
	}

	@Override
	public Result addLinkedinAdress(LinkedinAdress linkedinAdress) {
		this.linkedinAdressDao.save(linkedinAdress);
		return new SuccessResult("Linkedin adresi eklendi");
	}

}
