package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import hrmsfullBackend.hrms.business.absracts.JobSeekerLanguageService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.JobSeekerLanguageDao;
import hrmsfullBackend.hrms.entities.concretes.JobSeekerLanguage;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

public class JobSeekerLanguageManager implements JobSeekerLanguageService{

	private JobSeekerLanguageDao jobSeekerLanguageDao;
	private DtoConventerService dtoConventerService;
	
	
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao,
			DtoConventerService dtoConventerService) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage) {
		this.jobSeekerLanguageDao.save((JobSeekerLanguage) this.dtoConventerService.dtoClassConverter(jobSeekerLanguage, JobSeekerLanguage.class));
		return new SuccessResult("CV alanına yabancı dil bilgisi eklendi!");
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByCVId(int id) {
		if(this.jobSeekerLanguageDao.getJobSeekerLanguageByCVId(id).isEmpty()) {
			return new ErrorDataResult<List<JobSeekerLanguage>>("Yabancı dil bilgisi bulunamadı!");
		}else {
			return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.getJobSeekerLanguageByCVId(id), "Yabancı dil bilgisi listelendi!");
		}
		
	}

	@Override
	public Result deleteJobSeekerLanguageById(int id) {
		this.jobSeekerLanguageDao.deleteJobSeekerById(id);
		return new SuccessResult("Yabancı dil bilgisi silindi!");
	}

}
