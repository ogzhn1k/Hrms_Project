package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{

}
