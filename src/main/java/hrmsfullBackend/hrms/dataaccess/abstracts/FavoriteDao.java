package hrmsfullBackend.hrms.dataaccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsfullBackend.hrms.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
	
	List<Favorite> getFavoriteById(int id);
	
	@Transactional
	void deleteFavoriteByJoobSekeerIdAndJobAdvertId();

}
