package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getJobSeekers();
	DataResult<JobSeeker> getJobSeekerById(int id);
	Result addJobSeeker(JobSeeker jobSeeker);
	Result deleteJobSeekerById(int id);
	

}
