package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.School;

public interface SchoolService {

	 Result addSchool(School school);
	 DataResult<List<School>> getAllSchool();
}
