package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.GithubAdressService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.GithubAdressDao;
import oguzhanspring.hrms.hrms.entities.concretes.GithubAdress;

@Service
public class GithubAdressManager implements GithubAdressService{

	private GithubAdressDao githubAdressDao;
	
	@Autowired
	public GithubAdressManager(GithubAdressDao githubAdressDao) {
		super();
		this.githubAdressDao = githubAdressDao;
	}

	@Override
	public DataResult<List<GithubAdress>> getAllGithubAdresses() {
		return new SuccessDataResult<List<GithubAdress>>(this.githubAdressDao.findAll(),"Github adresleri listelendi");
	}

	@Override
	public Result addGithubAdress(GithubAdress githubAdress) {
		this.githubAdressDao.save(githubAdress);
		return new SuccessResult("Github adresi eklendi");
	}

}
