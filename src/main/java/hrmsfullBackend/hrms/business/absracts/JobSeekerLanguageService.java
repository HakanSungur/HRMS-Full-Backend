package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobSeekerLanguage;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

public interface JobSeekerLanguageService {

	Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage);
	DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByCVId(int id);
	Result deleteJobSeekerLanguageById(int id);
}
