package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {

	List<Technology> getTechnologyByCVId(int id);
	
	@Transactional
	void deleteTechnologyById(int id);
	
}
