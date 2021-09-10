package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobExperience;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobExperienceAddDto;

public interface JobExperienceService {
	
	Result addJobExperience(JobExperienceAddDto jobExperience);
	DataResult<List<JobExperience>> getJobExperienceByCvId(int id);
	Result deleteJobExperienceById(int id);

}
