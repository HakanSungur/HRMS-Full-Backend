package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hrmsfullBackend.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	List<JobAdvert> findAllByIsActiveTrue();
	List<JobAdvert> getJobAdvertByEmployer_CompanyName(String companyName, Sort sort);
	List<JobAdvert> getJobAdvertByEmployerId(int EmployerId, Sort sort);
	List<JobAdvert> findAllByIsActiveTrue(Sort sort);
	List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(Pageable pageable);
	List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue();
	
	@Transactional
	@Modifying
	@Query("Update JobAdvert set isConfirmed =:confirm where id =:jobAdvertId")
	void changeIsConfirmed(boolean confirm, int jobAdvertId);
	
	JobAdvert getJobAdvertById(int id);
	
	@Transactional
	void deleteJobAdvertById(int id);
}
