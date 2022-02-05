package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer>{

}
