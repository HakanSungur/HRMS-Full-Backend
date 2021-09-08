package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Department;

public interface DeparmentService {

	DataResult<List<Department>> getDepartment();
	Result addDepartment(Department department);
	
}
