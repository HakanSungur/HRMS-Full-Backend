package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobAdvert;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobAdvertAddDto;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getJobAdverts();
	DataResult<List<JobAdvert>> getSortedJobAdverts();
	DataResult<List<JobAdvert>> getActiveJobAdverts();
	DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName);
	DataResult<List<JobAdvert>> getJobAdvertByEmployerId(int employerId);
	DataResult<List<JobAdvert>> findAllByIsActiveTrue(boolean isDesc);
	DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo, int pageSize);
	DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize);
	DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue();
	DataResult<JobAdvert> getJobAdvertById(int id);
	Result changeIsActive(boolean active, int id); 
	Result changeIsConfirmed(boolean confirm, int id);
	Result addJobAdvert(JobAdvertAddDto jobAdvert);
	//Update eklenebilir.
	Result deleteJobAdvertById(int id); 
}
