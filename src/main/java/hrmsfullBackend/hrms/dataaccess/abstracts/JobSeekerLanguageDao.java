package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {

	List<JobSeekerLanguage> getJobSeekerLanguageByCVId(int id);
	
	@Transactional
	void deleteJobSeekerById(int id);
}
