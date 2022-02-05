package oguzhanspring.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import oguzhanspring.hrms.hrms.business.abstracts.PhotoService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Photo;

@RestController
@RequestMapping(value = "/api/photos")
@CrossOrigin
public class PhotosController {
	
	private PhotoService photoService;

	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@GetMapping(value = "/getAllPhotos")
    public DataResult<List<Photo>> getAllPhotos(){
		return this.photoService.getAllPhotos();
    }
	
	@PostMapping(value = "/addPhoto")//,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = "application/json")
	public ResponseEntity<Result> addPhoto(@RequestParam int resumeId,@RequestPart MultipartFile multipartFile) {
		return  ResponseEntity.ok(this.photoService.addPhoto(resumeId, multipartFile));
	}

}
