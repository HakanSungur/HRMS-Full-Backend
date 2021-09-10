package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getPositions();
	Result addJobPosition(JobPosition jobPosition);
}
