package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.AbilityService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.AbilityDao;
import oguzhanspring.hrms.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService{

	private AbilityDao abilityDao;
	
	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		super();
		this.abilityDao = abilityDao;
	}

	@Override
	public DataResult<List<Ability>> getAllabilities() {
		return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll(),"Yetenekler listelendi");
	}

	@Override
	public Result addAbility(Ability ability) {
		return new SuccessResult("Yetenek eklendi");
	}

}
