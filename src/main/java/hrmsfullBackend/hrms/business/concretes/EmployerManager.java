package hrmsfullBackend.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.business.absracts.EmployerService;
import hrmsfullBackend.hrms.core.services.CloudinaryService;
import hrmsfullBackend.hrms.core.services.EmailCheckService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.core.validators.EmailValidator;
import hrmsfullBackend.hrms.dataaccess.abstracts.EmployerDao;
import hrmsfullBackend.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private CloudinaryService cloudinaryService;
	private EmailCheckService emailCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, CloudinaryService cloudinaryService,
			EmailCheckService emailCheckService) {
		super();
		this.employerDao = employerDao;
		this.cloudinaryService = cloudinaryService;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<Employer>> getEmployers() {
		if((long) this.employerDao.findAll().size()>0 ) {
			return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
		}else {
			return new ErrorDataResult<List<Employer>>("İş veren bulunamadı");
		}
	}

	@Override
	public Result updateEmployer(Employer employer) {
		String[] employerWebsite=employer.getWebsite().split("\\",2);
		String webSite=employerWebsite[1];
		String[] employerEmail=employer.getEmail().split("@");
		String employerDomain=employerEmail[1];
		try {
			if(!EmailValidator.emailFormatController(employer.getEmail())) {
				return new ErrorResult("E-Mail formata uygun değil");
			}else if(! webSite.contains("www.")&& webSite.contains(".")) {
				return new ErrorResult("Website adresi formata uygun değil. ÖRN: www.google.com");
			}else if(!employerDomain.equalsIgnoreCase(webSite)) {
				return new ErrorResult("Web sitesi ile e-mail aynı domaine sahip değil. ");
			}else {
				this.employerDao.save(employer);
				return new SuccessResult("İş veren bilgisi güncellendi.");
			}
			
		} catch (Exception e) {
			if(e.getMessage().contains("[uc_users_email]")) {
				return new ErrorResult("E-Mail adresi sistemde kayıtlı, lütfen başka bir mail adresi giriniz!");
				
			}else {
				return new ErrorResult("Şirket adı sistemde kayıtlı, lütfen başka bir şirket adı giriniz.");
			}
		}
	}

	@Override
	public Result addEmployer(Employer employer) {
		String[] employerWebsite=employer.getWebsite().split("\\",2);
		String webSite=employerWebsite[1];
		String[] employerEmail=employer.getEmail().split("@");
		String employerDomain=employerEmail[1];
		try {
			if(!EmailValidator.emailFormatController(employer.getEmail())) {
				return new ErrorResult("E-Mail formata uygun değil");
			}else if(! webSite.contains("www.")&& webSite.contains(".")) {
				return new ErrorResult("Website adresi formata uygun değil. ÖRN: www.google.com");
			}else if(!employerDomain.equalsIgnoreCase(webSite)) {
				return new ErrorResult("Web sitesi ile e-mail aynı domaine sahip değil. ");
			}else {
				this.employerDao.save(employer);
				return new SuccessResult("İş veren sisteme eklendi. "+ emailCheckService.emailValidator(employer) );
			}
		}catch (Exception e) {
				if(e.getMessage().contains("[uc_users_email]")) {
					return new ErrorResult("E-Mail adresi sistemde kayıtlı, lütfen başka bir mail adresi giriniz!");
					
				}else {
					return new ErrorResult("Şirket adı sistemde kayıtlı, lütfen başka bir şirket adı giriniz.");
				}
			}
		
			
	}

	@Override
	public Result deleteEmployer(int id) {
		this.employerDao.deleteEmployerById(id);
		return new SuccessResult("İş veren silindi.");
	}

	@Override
	public DataResult<Employer> getEmployerById(int id) {
		if(this.employerDao.getById(id)==null) {
			return new ErrorDataResult<Employer>("İş veren bulunamadı.");
			
		}else {
			return new SuccessDataResult<Employer>(this.employerDao.getById(id), "İş veren listelendi.");
			
		}
	}

	@Override
	public Result uploadPicture(int employerId, MultipartFile pictureFile) throws IOException {
		 var result= this.cloudinaryService.addPicture(pictureFile);
		 var url=result.getData().get("url");
		 Employer employer =this.employerDao.getById(employerId);
		 employer.setPictureUrl(url.toString());
		 this.employerDao.save(employer);
		 return new SuccessResult("Resim ekleme işlemi başarılı!");
	}

	@Override
	public Result changeIsUpdated(boolean update, int employerId) {
		this.employerDao.changeIsUpdated(update, employerId);
		return new SuccessResult("Resim ekleme işlemi başarılı!");
	}

	@Override
	public DataResult<List<Employer>> getEmployerByUpdatedTrue() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getEmployerByIsUpdatedTrue(), "Bilgilerini güncellemek isteyen iş verenler başarıyla listelendi.");
	}

}
