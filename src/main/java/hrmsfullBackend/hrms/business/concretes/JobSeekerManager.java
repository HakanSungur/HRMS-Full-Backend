package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.JobSeekerService;
import hrmsfullBackend.hrms.core.services.EmailCheckService;
import hrmsfullBackend.hrms.core.services.MernisCheckService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.core.validators.EmailValidator;
import hrmsfullBackend.hrms.dataaccess.abstracts.JobSeekerDao;
import hrmsfullBackend.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private EmailCheckService emailCheckService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService,
			EmailCheckService emailCheckService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<JobSeeker>> getJobSeekers() {
		if((long) this.jobSeekerDao.findAll().size()>0) {
			return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi!");
		}else {
			return new ErrorDataResult<List<JobSeeker>>("İş arayanlar bulunamadı!");
		}
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerById(int id) {
		if(this.jobSeekerDao.getById(id)==null) {
			return new ErrorDataResult<JobSeeker>("İş arayan bulunamadı!");
			
		}else {
			return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id), "İş arayan listelendi!");
		}
	}

	@Override
	public Result addJobSeeker(JobSeeker jobSeeker) {
		try {
			if(!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
				return new ErrorResult("Email formata uygun değil!");
			}else if(!mernisCheckService.isMernis(jobSeeker)){
				return new ErrorResult("Kimlik bilgisi doğrulanamadı!");
				
			}else {
				this.jobSeekerDao.save(jobSeeker);
				return new SuccessResult("İş arayan kullanıcı bilgisi sisteme eklendi!"+ emailCheckService.emailValidator(jobSeeker));
			}
		} catch (Exception e) {
			if(e.getMessage().contains("[uc_users_email]")) {
				return new ErrorResult("Email adresi sistemde kayıtlı!");
				
			}else {
				return new ErrorResult("Kimlik bilgisi sistemde kayıtlı. Lütfen tekrar deneyiniz!");
			}
		}
	}

	@Override
	public Result deleteJobSeekerById(int id) {
		this.deleteJobSeekerById(id);
		return new SuccessResult("İş arayan silindi!");
	}
	
	

}
