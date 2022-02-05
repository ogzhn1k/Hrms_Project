package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.GithubAdress;

public interface GithubAdressDao extends JpaRepository<GithubAdress, Integer>{

}
