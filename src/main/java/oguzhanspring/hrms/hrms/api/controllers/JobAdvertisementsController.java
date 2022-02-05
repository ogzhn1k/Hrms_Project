package oguzhanspring.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oguzhanspring.hrms.hrms.business.abstracts.JobAdvertisementService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.dtos.JobActiveDto;
import oguzhanspring.hrms.hrms.entities.dtos.JobAdDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	private ResponseEntity<Result> add(@RequestBody JobAdDto jobAdDto) {
		return ResponseEntity.ok(this.jobAdvertisementService.addJobAdvertisement(jobAdDto));
	}
	
	@GetMapping("/getAllAds")
	private DataResult<List<JobActiveDto>>  getAllJobAds(){
		return this.jobAdvertisementService.findAllByIsActive(true);
	}
	
	@GetMapping("/getAllAdsSorted")
	private DataResult<List<JobActiveDto>>  getAllJobAdsSorted(){
		return this.jobAdvertisementService.findByIsActiveTrueOrderByLastApplicationAsc();
	}
	
	@GetMapping("/getAllAdsCompany")
	private DataResult<List<JobActiveDto>>  getAllJobAdsCompany(@RequestParam String companyName){
		return this.jobAdvertisementService.getByIsActiveAndEmployer_CompanyName(true, companyName);
	}
	
}
