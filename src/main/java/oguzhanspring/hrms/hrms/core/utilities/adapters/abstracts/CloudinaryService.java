package oguzhanspring.hrms.hrms.core.utilities.adapters.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	public DataResult<Map<String, String>> uploadImage(MultipartFile sourceFile)throws IOException;
	
}
