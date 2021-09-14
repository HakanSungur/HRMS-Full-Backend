package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.SchoolService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.SchoolDao;
import hrmsfullBackend.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result addSchool(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgisi eklendi!");
	}

	@Override
	public DataResult<List<School>> getAllSchool() {
		if(this.schoolDao.findAll().isEmpty()) {
			return new ErrorDataResult<List<School>>("Okul bilgisi bulunamadı!");
		
		}else {
			return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "Okul bilgisi listelendi!");
		}
	}
	
	

}
