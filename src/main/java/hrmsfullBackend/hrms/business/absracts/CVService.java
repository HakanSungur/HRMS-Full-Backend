package hrmsfullBackend.hrms.business.absracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.CV;
import hrmsfullBackend.hrms.entities.dtos.addDtos.CVAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.CVUpdateDto;

public interface CVService {

	Result addCv(CVAddDto cV);
	Result updateCv(CVUpdateDto cV);
	
	DataResult<CV> findByJobSeekerId(int jobseekerId);
	Result uploadPicture(int cVId, MultipartFile pictureFile)throws IOException;
}
