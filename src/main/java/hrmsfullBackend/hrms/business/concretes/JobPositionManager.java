package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.JobPositionService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.JobPositionDao;
import hrmsfullBackend.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	
	private JobPositionDao jobPositionDao;
	

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getPositions() {
		if((long) this.jobPositionDao.findAll().size()>0) {
			return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi!");
			
		}else {
			return new ErrorDataResult<List<JobPosition>>("İş pozisyonları bulunamadı!");
		}
	}

	//DTO ile yazılabilir. Sonuç görmek için yapıyorum.
	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		try {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("İş pozisyonu sisteme eklendi!");
		} catch (Exception e) {
			return new ErrorResult("İş pozisyonu sisteme eklenemedi!");
		}
	}

}
