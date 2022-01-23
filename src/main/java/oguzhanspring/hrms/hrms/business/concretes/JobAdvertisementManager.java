package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.JobAdvertisementService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import oguzhanspring.hrms.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveIs(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveIs(isActive),"Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllAdvertisements() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Tüm ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByLastApplicationAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByLastApplicationAsc(),"Aktif iş ilanları tarihe göre artan şekilde sıralandı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_CompanyName(isActive, companyName),"Firmaya ait aktif iş ilanları listelendi");
	}

	// TODO : İş ilanı pasif hale getirilecek
	
	// TODO : İş ilanı ekleme işlemi yapılacak
	
	// TODO : Son değişiklikler için veritabanı hazırlanacak

	
	
}
