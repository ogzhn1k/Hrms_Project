package oguzhanspring.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhanspring.hrms.hrms.business.abstracts.GithubAdressService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.GithubAdress;

@RestController
@RequestMapping(value = "/api/githubAdresses")
public class GithubAdressesController {
	
	private GithubAdressService githubAdressService;

	@Autowired
	public GithubAdressesController(GithubAdressService githubAdressService) {
		super();
		this.githubAdressService = githubAdressService;
	}
	
	@GetMapping(value = "/getAllGithubAdresses")
	public DataResult<List<GithubAdress>> getAllGithubAdresses(){
		return this.githubAdressService.getAllGithubAdresses();
		
	}
	
	@PostMapping(value = "/addGithubAdresses")
	public Result addGithubAdress(@RequestBody GithubAdress githubAdress) {
		return this.githubAdressService.addGithubAdress(githubAdress);
	}
}
