package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	
	List<Job> findByJobName(String jobName);
	Job getByJobName(String jobName);
}
