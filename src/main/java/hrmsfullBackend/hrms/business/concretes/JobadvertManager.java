package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.JobAdvertService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.JobAdvertDao;
import hrmsfullBackend.hrms.entities.concretes.JobAdvert;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobAdvertAddDto;

@Service
public class JobadvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	private DtoConventerService dtoConventerService;
	
	@Autowired
	public JobadvertManager(JobAdvertDao jobAdvertDao, DtoConventerService dtoConventerService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdverts() {
		if((long) this.jobAdvertDao.findAll().size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "Tüm iş ilanları listelendi.");
		}
		return new ErrorDataResult<List<JobAdvert>>("İş ilanı bulunamadı.");
	}

	@Override
	public DataResult<List<JobAdvert>> getSortedJobAdverts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdverts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByEmployerId(int employerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByIsActiveTrue(boolean isDesc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobAdvert> getJobAdvertById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changeIsActive(boolean active, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changeIsConfirmed(boolean confirm, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addJobAdvert(JobAdvertAddDto jobAdvert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteJobAdvertById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
