package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.LanguageService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.LanguageDao;
import hrmsfullBackend.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> addLanguages(List<Language> languages) {
		this.languageDao.saveAll(languages);
		return new SuccessDataResult<List<Language>>("Yabancı diller eklendi!");
	}

	@Override
	public DataResult<List<Language>> getLanguages() {
		if(this.languageDao.findAll().isEmpty()) {
			return new ErrorDataResult<List<Language>>("Yabancı diller bulunamadı!");
		}else {
			return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Yabancı diller listelendi!");
		}
	}
	
	
	

}
