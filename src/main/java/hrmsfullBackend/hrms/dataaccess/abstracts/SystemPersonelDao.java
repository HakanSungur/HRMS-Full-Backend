package hrmsfullBackend.hrms.dataaccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel, Integer> {

	SystemPersonel getSystemPersonelById(int id);
	
	@Transactional
	void deleteSystemPersonelById(int id);
}
