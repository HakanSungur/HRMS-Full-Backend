package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.EducationService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.EducationDao;
import hrmsfullBackend.hrms.entities.concretes.Education;
import hrmsfullBackend.hrms.entities.dtos.addDtos.EducationAddDto;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	private DtoConventerService dtoConventerService;

	@Autowired
	public EducationManager(EducationDao educationDao, DtoConventerService dtoConventerService) {
		super();
		this.educationDao = educationDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public Result addEducation(EducationAddDto education) {
		this.educationDao.save((Education)
		this.dtoConventerService.dtoClassConverter(education, Education.class));
		return new SuccessResult("Eğitim bilgileri eklendi.");
	}

	@Override
	public DataResult<List<Education>> getAllEducations() {
		if(this.educationDao.findAll().isEmpty()) {
			return new ErrorDataResult<List<Education>>("Eğitim bilgisi bulunamadı.");
		}else {
			return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Eğitim bilgisi listelendi.");
					
		}
	}

	@Override
	public DataResult<List<Education>> getEducationByCVId(int id) {
		Sort sort=Sort.by(Sort.Direction.DESC, "endDate");
		if (this.educationDao.getEducationEndDateByCVId(id, sort).isEmpty()) {
            return new ErrorDataResult<List<Education>>("Eğitim bilgisi bulunamadı.");
        } else {
            return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Eğitim bilgisi listelendi");
            }
	}

	@Override
	public Result deleteEducationById(int id) {
		this.educationDao.deleteEducationById(id);
		return new SuccessResult("Eğitim bilgisi başarı ile silindi.");
	}

}
