package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Education;

public interface EducationService {

	Result addEducation(Education education);
	DataResult<List<Education>> getAllEducations();
	DataResult<List<Education>> getEducationByCVId();
	Result deleteEducationById(int id);
}
