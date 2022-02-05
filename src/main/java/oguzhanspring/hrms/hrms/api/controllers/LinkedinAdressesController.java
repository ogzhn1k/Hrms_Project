package oguzhanspring.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhanspring.hrms.hrms.business.abstracts.LinkedinAdressService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.LinkedinAdress;

@RestController
@RequestMapping(value = "/api/linkedinAdresses")
public class LinkedinAdressesController {
	
	private LinkedinAdressService linkedinAdressService;

	@Autowired
	public LinkedinAdressesController(LinkedinAdressService linkedinAdressService) {
		super();
		this.linkedinAdressService = linkedinAdressService;
	}
	
	@GetMapping(value = "/getAllLinkedinAdresses")
	public DataResult<List<LinkedinAdress>> getAllGithubAdresses(){
		return this.linkedinAdressService.getAllLinkedinAdresses();
		
	}
	
	@PostMapping(value = "/addLinkedinAdresses")
	public Result addLinkedinAdress(@RequestBody LinkedinAdress linkedinAdress) {
		return this.linkedinAdressService.addLinkedinAdress(linkedinAdress);
	}
	
	
}
