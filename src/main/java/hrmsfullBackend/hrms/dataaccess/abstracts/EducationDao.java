package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	 List<Education> getEducationEndDateByCVId(int id, Sort sort);
	 
	 @Transactional
	 void deleteEducationById(int id);
}
