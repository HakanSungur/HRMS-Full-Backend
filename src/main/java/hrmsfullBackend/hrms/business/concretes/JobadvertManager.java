package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş ilanı bulunamadı.");
		}
		
	}

	@Override
	public DataResult<List<JobAdvert>> getSortedJobAdverts() {
		Sort sort=Sort.by(Sort.Direction.ASC,"id");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort), "İş ilanları sıralandı.");
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdverts() {
		if((long) this.jobAdvertDao.findAllByIsActiveTrue().size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByIsActiveTrue(), "Aktif iş ilanları listelendi.");
			
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş ilanları bulunamadı");
		}
		
		
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
		Sort sort=Sort.by(Sort.Direction.ASC,"id");
		if((long) this.jobAdvertDao.getJobAdvertByEmployer_CompanyName(companyName, sort).size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByEmployer_CompanyName(companyName, sort), "İş verene ait tüm ilanlar listelendi.");
		}else {
			return new ErrorDataResult<List<JobAdvert>>(companyName + "İş verenine ait ilanlar bulunamadı!");
		}
		
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByEmployerId(int employerId) {
		Sort sort=Sort.by(Sort.Direction.ASC,"isConfirmed","id");
		if((long) this.jobAdvertDao.getJobAdvertByEmployerId(employerId, sort).size()>0 ) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByEmployerId(employerId, sort), "İş verene ait tüm ilanlar listelendi.");
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş verene ait ilan bulunamadı!");
		}
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
