package hrmsfullBackend.hrms.business.concretes;

import hrmsfullBackend.hrms.business.absracts.EmployerUpdateService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.EmployerUpdateDao;
import hrmsfullBackend.hrms.entities.concretes.EmployerUpdate;

public class EmployerUpdateManager implements EmployerUpdateService {

	private EmployerUpdateDao employerUpdateDao;
	
	public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
		super();
		this.employerUpdateDao = employerUpdateDao;
	}

	@Override
	public DataResult<EmployerUpdate> getEmployerUpdateById(int employerId) {
		if(this.employerUpdateDao.getEmployerUpdateById(employerId)==null) {
			return new ErrorDataResult<EmployerUpdate>("Kayıtlı iş veren bulunamadı.");
		}else {
			return new SuccessDataResult<EmployerUpdate>(this.employerUpdateDao.getEmployerUpdateById(employerId), "İş veren başarıyla listelendi.");
		}
	}

	@Override
	public Result deleteEmployerUpdateById(int emplayerId) {
		this.employerUpdateDao.deleteEmployerUpdateById(emplayerId);
		return new SuccessResult("İş veren silindi.");
	}

	@Override
	public Result addEmployerUpdate(EmployerUpdate employerUpdate) {
		this.employerUpdateDao.save(employerUpdate);
		return new SuccessResult("İş veren eklendi.");
	}

}
