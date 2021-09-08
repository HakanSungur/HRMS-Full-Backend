package hrmsfullBackend.hrms.business.absracts;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<City> getCities();

}
