package hrmsfullBackend.hrms.business.absracts;



import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {

	DataResult<EmployerUpdate> getEmployerUpdateById(int employerId);
	Result deleteEmployerUpdateById(int emplayerId);
	Result addEmployerUpdate(EmployerUpdate employerUpdate);
}
