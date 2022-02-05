package oguzhanspring.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhanspring.hrms.hrms.business.abstracts.JobAdvertisementService;
import oguzhanspring.hrms.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import oguzhanspring.hrms.hrms.core.utilities.results.DataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.Result;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessDataResult;
import oguzhanspring.hrms.hrms.core.utilities.results.SuccessResult;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.CityDao;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.EmployerDao;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.JobAdvertisementDao;
import oguzhanspring.hrms.hrms.dataAccess.abstracts.JobDao;
import oguzhanspring.hrms.hrms.entities.concretes.JobAdvertisement;
import oguzhanspring.hrms.hrms.entities.dtos.JobActiveDto;
import oguzhanspring.hrms.hrms.entities.dtos.JobAdDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private CityDao cityDao;	
	private JobDao jobDao;
	private EmployerDao employerDao;
	private DtoConverterService dtoConverterService;

    @Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao,JobDao jobDao, EmployerDao employerDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.jobDao = jobDao;
		this.employerDao = employerDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result addJobAdvertisement(JobAdDto jobAdDto) {
		
		JobAdvertisement jobAdvertisement = (JobAdvertisement)this.dtoConverterService.dtoToEntity(jobAdDto, JobAdvertisement.class);

		
	    jobAdvertisement.setActive(true);
		jobAdvertisement.setMinSalary(jobAdDto.getMinSalary());
		jobAdvertisement.setMaxSalary(jobAdDto.getMaxSalary());
		jobAdvertisement.setJobDescription(jobAdDto.getJobDescription());
		jobAdvertisement.setOpenPositionNumber(jobAdDto.getOpenPositionNumber());
		jobAdvertisement.setLastApplication(jobAdDto.getLastApplication());
		
		jobAdvertisement.setCity(this.cityDao.getByCityName(jobAdDto.getCityName()));
		jobAdvertisement.setJob(this.jobDao.getByJobName(jobAdDto.getJobName()));
		jobAdvertisement.setEmployer(this.employerDao.getByCompanyName(jobAdDto.getCompanyName()));
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("İş ilanı eklendi") ;
	}

	@Override
	public DataResult<List<JobActiveDto>> findAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobActiveDto>>(this.dtoConverterService.entityToDto(jobAdvertisementDao.findAllByIsActive(isActive), JobActiveDto.class),"Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllAdvertisements() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Tüm ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobActiveDto>> findByIsActiveTrueOrderByLastApplicationAsc() {
		return new SuccessDataResult<List<JobActiveDto>>( this.dtoConverterService.entityToDto(jobAdvertisementDao.findAllByIsActiveTrueOrderByLastApplicationAsc(), JobActiveDto.class),"Aktif iş ilanları tarihe göre artan şekilde sıralandı");
	}

	@Override
	public DataResult<List<JobActiveDto>> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName) {
		return new SuccessDataResult<List<JobActiveDto>>(this.dtoConverterService.entityToDto(jobAdvertisementDao.findAllByIsActiveAndEmployer_CompanyName(isActive, companyName), JobActiveDto.class),"Firmaya ait aktif iş ilanları listelendi");
	}

	@Override
	public void closeJobAdvertisement(int employer_id) {
		this.jobAdvertisementDao.closeJobAdvertisement(employer_id);
	}
	
			
}
