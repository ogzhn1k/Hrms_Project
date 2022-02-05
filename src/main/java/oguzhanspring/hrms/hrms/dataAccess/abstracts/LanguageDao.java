package oguzhanspring.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhanspring.hrms.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
