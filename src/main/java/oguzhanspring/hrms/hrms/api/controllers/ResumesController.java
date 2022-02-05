package oguzhanspring.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhanspring.hrms.hrms.business.abstracts.ResumeService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Resume;

@RestController
@RequestMapping(value = "/api/resumes")
@CrossOrigin
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping(value = "/getAllResumes")
	public DataResult<List<Resume>> getAllResumes(){
		return this.resumeService.getAllResumes();
	}
	
	@PostMapping(value = "/addResume")
	public Result addResume(@RequestBody Resume resume) {
		return this.resumeService.addResume(resume);
	}
}
