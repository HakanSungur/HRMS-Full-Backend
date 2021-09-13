package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Favorite;
import hrmsfullBackend.hrms.entities.dtos.addDtos.FavoriteAddDto;

public interface FavoriteService {

	Result addFavorite(FavoriteAddDto favorite);
	Result deleteFavorite(int id);
	
	Result deleteFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);
	DataResult<List<Favorite>> getFavorites();
	DataResult<List<Favorite>> getFavoriteId(int id);
}
