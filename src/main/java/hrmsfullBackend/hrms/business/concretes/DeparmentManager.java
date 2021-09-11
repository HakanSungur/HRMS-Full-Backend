package hrmsfullBackend.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrmsfullBackend.hrms.business.absracts.DeparmentService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.DeparmentDao;
import hrmsfullBackend.hrms.entities.concretes.Department;

@Service
public class DeparmentManager implements DeparmentService {

	private DeparmentDao departmentDao;
	
	@Autowired
	public DeparmentManager(DeparmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getDepartment() {
		if(this.departmentDao.findAll().isEmpty()) {
			return new ErrorDataResult<List<Department>>("Kayıt bulunamadı;");
			
		}else {
			return new DataResult<List<Department>>(this.departmentDao.findAll(), true);
		}
		
	}

	@Override
	public Result addDepartment(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Departman eklendi.");
				
	}

}
