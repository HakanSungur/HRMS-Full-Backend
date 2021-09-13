package hrmsfullBackend.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrmsfullBackend.hrms.business.absracts.FavoriteService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.FavoriteDao;
import hrmsfullBackend.hrms.entities.concretes.Favorite;
import hrmsfullBackend.hrms.entities.dtos.addDtos.FavoriteAddDto;

@Service
public class FavoriteManager implements FavoriteService {

	private FavoriteDao favoriteDao;
	private DtoConventerService dtoConventerService;
	
	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao, DtoConventerService dtoConventerService) {
		super();
		this.favoriteDao = favoriteDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public Result addFavorite(FavoriteAddDto favorite) {
		this.favoriteDao.save((Favorite)this.dtoConventerService.dtoClassConverter(favorite, Favorite.class));
		return new SuccessResult("Favorilere eklendi.");
	}

	@Override
	public Result deleteFavorite(int id) {
		this.favoriteDao.deleteById(id);
		return new SuccessResult("Favori başarıyla kaldırıldı!");
	}

	@Override
	public Result deleteFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId) {
		this.favoriteDao.deleteFavoriteByJoobSekeerIdAndJobAdvertId(jobSeekerId,jobAdvertId);
		return new SuccessResult("Favori başarıyla kaldırıldı!");
	}

	@Override
	public DataResult<List<Favorite>> getFavorites() {
		if(this.favoriteDao.findAll().size()>0) {
			return new SuccessDataResult<List<Favorite>>(this.favoriteDao.findAll(), "Favoriler başarıyla listelendi!");
			
		}else {
			return new ErrorDataResult<List<Favorite>>("Favori listesi bulunamadı.");
		}
	}

	@Override
	public DataResult<List<Favorite>> getFavoriteId(int id) {
		if (this.favoriteDao.getFavoriteByJobSeekerId(id).size() > 0) {
			return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getFavoriteByJobSeekerId(id), id+ "id nolu iş arayana ait favoriler listelendi.");
		}else {
			return new ErrorDataResult<List<Favorite>>(this.favoriteDao.getFavoriteByJobSeekerId(id), id+ "id nolu iş arayana ait favori bulunamadı!");
		}
	}

	

	

}
