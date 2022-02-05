package oguzhanspring.hrms.hrms.business.abstracts;

import java.util.List;

import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.entities.concretes.Language;

public interface LanguageService {
	
	DataResult<List<Language>> getAllLangs();
	
	Result addLanguage(Language language);

}
