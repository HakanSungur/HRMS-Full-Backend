package hrmsfullBackend.hrms.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.CV;

public interface CVDao extends JpaRepository<CV, Integer> {

	
	CV findByJobSeekerId(int id);
}
