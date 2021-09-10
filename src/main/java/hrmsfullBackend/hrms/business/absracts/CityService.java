package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City> > getCities();

}
