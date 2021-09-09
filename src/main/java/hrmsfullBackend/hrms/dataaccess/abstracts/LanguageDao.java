package hrmsfullBackend.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

	
}
