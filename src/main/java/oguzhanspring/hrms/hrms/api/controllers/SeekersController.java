package oguzhanspring.hrms.hrms.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhanspring.hrms.hrms.business.abstracts.SeekerService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Seeker;

@CrossOrigin
@RestController
@RequestMapping("/api/seekers")
public class SeekersController {
	
	private SeekerService seekerService;

	@Autowired
	public SeekersController(SeekerService seekerService) {
		super();
		this.seekerService = seekerService;
	}
	
    
	@GetMapping("/getall")
    public DataResult<List<Seeker>> getall(){
    	return this.seekerService.getAllSeekers();
    }
	
	@PostMapping("/add")
    public Result add(@RequestBody Seeker seeker) throws NumberFormatException, RemoteException {
    	
    	return this.seekerService.addSeeker(seeker);
    }
	

}
