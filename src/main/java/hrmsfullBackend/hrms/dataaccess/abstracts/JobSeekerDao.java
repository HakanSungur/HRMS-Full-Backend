package hrmsfullBackend.hrms.dataaccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

	JobSeeker getJobSeekerById(int id);
	
	@Transactional
	void deleteJobSeekerById(int id);
}
