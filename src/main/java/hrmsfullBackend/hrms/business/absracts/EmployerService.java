package hrmsfullBackend.hrms.business.absracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getEmployers();
	Result updateEmployer(Employer employer);
	Result addEmployer(Employer employer);
	Result deleteEmployer(int employerId);
	
	DataResult<Employer> getEmployerById(int id);
	//resim yükleme hata veriyor bakılacak...
	Result uploadPicture(int employerId, MultipartFile pictureFile) throws IOException;
	
	Result changeIsUpdated(boolean update, int employerId);
	DataResult<List<Employer>> getEmployerByUpdatedTrue();
	
}
