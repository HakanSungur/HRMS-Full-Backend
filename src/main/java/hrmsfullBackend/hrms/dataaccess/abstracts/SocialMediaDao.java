package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
	
	List<SocialMedia> getSocialMediaByCVId(int id);

}
