package oguzhanspring.hrms.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.var;
import oguzhanspring.hrms.hrms.business.abstracts.PhotoService;
import oguzhanspring.hrms.hrms.core.utilities.adapters.abstracts.CloudinaryService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.ErrorResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.PhotoDao;
import oguzhanspring.hrms.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<Photo>> getAllPhotos() {
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(),"Fotoğraf metadatası listelendi");
	}

	@Override
	public Result addPhoto(int resumeId, MultipartFile multipartFile) {
		
		try {
			var result = this.cloudinaryService.uploadImage(multipartFile).getData();
			
			//photo.setPhotoURL(result.get("url"));

		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorResult("Fotoğraf eklenemedi");
		}
		
		//this.photoDao.save(photo);
		
		return new SuccessResult("Fotoğraf eklendi");
	}

}
