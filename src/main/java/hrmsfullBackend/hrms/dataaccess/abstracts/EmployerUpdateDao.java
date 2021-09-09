package hrmsfullBackend.hrms.dataaccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

	EmployerUpdate getEmployerUpdateById(int id);
	
	 @Transactional
	 void deleteEmployerUpdateById(int id);
}
