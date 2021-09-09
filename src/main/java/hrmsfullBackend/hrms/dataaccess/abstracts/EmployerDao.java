package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hrmsfullBackend.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	Employer getEmployerById(int id);
	List<Employer> getEmployerByIsUpdatedTrue();

	 @Transactional
	 void deleteEmployerById(int id);
	 
	 @Transactional
	 @Modifying
	 @Query("Update Employer set isUpdated =:update where id =:employerId")
	 void changeIsUpdated(boolean update, int employerId);
}
