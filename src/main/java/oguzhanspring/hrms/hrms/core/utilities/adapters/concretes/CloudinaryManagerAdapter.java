package oguzhanspring.hrms.hrms.core.utilities.adapters.concretes;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import oguzhanspring.hrms.hrms.core.utilities.adapters.abstracts.CloudinaryService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.ErrorDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManagerAdapter implements CloudinaryService{
	
	private final Cloudinary cloudinary;
	
	public CloudinaryManagerAdapter() {
		
		Map<String, String> valuesMap = new HashMap<>();
		
		valuesMap.put( "cloud_name", "ogzhn1k");
		
		valuesMap.put("api_key", "118336555788418");
		
		valuesMap.put("api_secret", "1p3Vp4l8Qwh94cbkp5g8c4jkEIo");
		
		cloudinary = new Cloudinary(valuesMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<Map<String, String>> uploadImage(MultipartFile sourceFile) throws IOException{
		
		File file;
		
		
		try {
			
			file = this.convertMultipartToFile(sourceFile);
			Map<String, String> imageResult = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			
			return new SuccessDataResult<>(imageResult);
	
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorDataResult<>("Dosya yükleme hatası");
		}
		
	}
	
	 private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream stream = new FileOutputStream(file);
	        stream.write(multipartFile.getBytes());
	        stream.close();

	        return file;
	    }
	
	

}
