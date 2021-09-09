package hrmsfullBackend.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

	
}
