package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Education;
import hrmsfullBackend.hrms.entities.dtos.addDtos.EducationAddDto;

public interface EducationService {

	Result addEducation(EducationAddDto education);
	DataResult<List<Education>> getAllEducations();
	DataResult<List<Education>> getEducationByCVId();
	Result deleteEducationById(int id);
}
