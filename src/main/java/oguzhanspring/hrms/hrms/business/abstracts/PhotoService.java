package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Photo;

public interface PhotoService {

	DataResult<List<Photo>> getAllPhotos();
	
	Result addPhoto(int resumeId,MultipartFile multipartFile);
}
