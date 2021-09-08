package hrmsfullBackend.hrms.business.absracts;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.CV;

public interface CVService {

	Result addCv(CV cV);
	Result updateCv(CV cV);
	
	DataResult<CV> findByJobSeekerId(int jobseekerId);
	
}
