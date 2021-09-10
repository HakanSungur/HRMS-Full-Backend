package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.entities.concretes.Language;

public interface LanguageService {

	DataResult<List<Language>> addLanguages(List<Language> languages);
	DataResult<List<Language>> getLanguages();
}
