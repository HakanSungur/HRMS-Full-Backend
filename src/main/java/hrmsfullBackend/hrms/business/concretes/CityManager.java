package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.CityService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.CityDao;
import hrmsfullBackend.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService {

	
	private final CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getCities() {
		if ((long) this.cityDao.findAll().size() > 0) {
			return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler listelendi!");
		}
		return new ErrorDataResult<List<City>>("Şehirler listelenemedi.");
	}

	

}
