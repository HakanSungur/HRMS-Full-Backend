package hrmsfullBackend.hrms.business.concretes;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.business.absracts.CVService;
import hrmsfullBackend.hrms.core.services.CloudinaryService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.CVDao;
import hrmsfullBackend.hrms.entities.concretes.CV;
import hrmsfullBackend.hrms.entities.dtos.addDtos.CVAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.CVUpdateDto;

public class CVManager implements CVService {
	
	private CVDao CVDao;
	private DtoConventerService dtoConventerService;
	private CloudinaryService CloudinaryService;

	public CVManager(CVDao cVDao, DtoConventerService dtoConventerService,
			CloudinaryService cloudinaryService) {
		super();
		CVDao = cVDao;
		this.dtoConventerService = dtoConventerService;
		CloudinaryService = cloudinaryService;
	}

	@Override
	public Result addCv(CVAddDto cV) {
		if (cV.getPictureUrl().equals("")) {
			cV.setPictureUrl("http://toraistanbul.com/wp-content/uploads/2018/08/bos-profil.png");
			this.CVDao.save((CV) this.dtoConventerService.dtoClassConverter(cV, CV.class));
			return new SuccessResult("CV başarı ile eklendi.");
		}else {
			this.CVDao.save((CV) this.dtoConventerService.dtoClassConverter(cV, CV.class));
			return new SuccessResult("CV başarı ile eklendi.");
		}
		
	}

	@Override
	public Result updateCv(CVUpdateDto cV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CV> findByJobSeekerId(int jobseekerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result uploadPicture(int cVId, MultipartFile pictureFile) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
