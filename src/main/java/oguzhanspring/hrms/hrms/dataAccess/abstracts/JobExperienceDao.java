package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{

}
