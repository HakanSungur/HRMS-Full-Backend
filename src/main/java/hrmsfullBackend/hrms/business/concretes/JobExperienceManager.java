package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.JobExperienceService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.JobExperienceDao;
import hrmsfullBackend.hrms.entities.concretes.JobExperience;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobExperienceAddDto;

@Service

public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private DtoConventerService dtoConventerService;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConventerService dtoConventerService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public Result addJobExperience(JobExperienceAddDto jobExperience) {
		this.jobExperienceDao.save((JobExperience) this.dtoConventerService.dtoClassConverter(jobExperience, JobExperienceAddDto.class));
		return new SuccessResult("İş tecrübesi bilgisi eklendi!");
	}

	@Override
	public DataResult<List<JobExperience>> getJobExperienceByCvId(int id) {
		Sort sort=Sort.by(Sort.Direction.DESC, "endDate");
		if(this.jobExperienceDao.getJobExperienceEndDateByCVId(id, sort).isEmpty()) {
			return new ErrorDataResult<List<JobExperience>>("Listelenecek iş tecrübesi bilgisi bulunamadı!");
			
		}else {
			return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getJobExperienceEndDateByCVId(id, sort), "İş tecrübesi bilgileri sırayla listelendi.");
		}
	}

	@Override
	public Result deleteJobExperienceById(int id) {
		this.jobExperienceDao.deleteJobExperineceById(id);
		return new SuccessResult("İş tecrübesi bilgisi silindi!");
	}

}
