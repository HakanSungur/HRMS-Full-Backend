package hrmsfullBackend.hrms.business.concretes;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.business.absracts.CVService;
import hrmsfullBackend.hrms.core.services.CloudinaryService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.CVDao;
import hrmsfullBackend.hrms.entities.concretes.CV;
import hrmsfullBackend.hrms.entities.dtos.addDtos.CVAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.CVUpdateDto;

@Service
public class CVManager implements CVService {
	
	private CVDao cVDao;
	private DtoConventerService dtoConventerService;
	private CloudinaryService cloudinaryService;

	@Autowired
	public CVManager(CVDao cVDao, DtoConventerService dtoConventerService,
			CloudinaryService cloudinaryService) {
		super();
		this.cVDao = cVDao;
		this.dtoConventerService = dtoConventerService;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result addCv(CVAddDto cV) {
		if (cV.getPictureUrl().equals("")) {
			cV.setPictureUrl("http://toraistanbul.com/wp-content/uploads/2018/08/bos-profil.png");
			this.cVDao.save((CV) this.dtoConventerService.dtoClassConverter(cV, CV.class));
			return new SuccessResult("CV başarı ile eklendi.");
		}else {
			this.cVDao.save((CV) this.dtoConventerService.dtoClassConverter(cV, CV.class));
			return new SuccessResult("CV başarı ile eklendi.");
		}
		
	}

	@Override
	public Result updateCv(CVUpdateDto cV) {
		if (cV.getPictureUrl().equals("")) {
			cV.setPictureUrl("http://toraistanbul.com/wp-content/uploads/2018/08/bos-profil.png");
			this.cVDao.save((CV) this.dtoConventerService.dtoClassConverter(cV, CV.class));
			return new SuccessResult("CV başarı ile güncellendi.");
		}else {
			this.cVDao.save((CV) this.dtoConventerService.dtoClassConverter(cV, CV.class));
			return new SuccessResult("CV başarı ile güncellendi.");
		}
	}

	@Override
	public DataResult<CV> findByJobSeekerId(int jobseekerId) {
		if(this.cVDao.findByJobSeekerId(jobseekerId)==null ) {
			return new ErrorDataResult<CV>("Kayıtlı CV bulunamadı!");
		}else {
			return new SuccessDataResult<CV>(this.cVDao.findByJobSeekerId(jobseekerId), "CV'ler listelendi.");
		}
	}

	@Override
	public Result uploadPicture(int cVId, MultipartFile pictureFile) throws IOException {
		var result = this.cloudinaryService.addPicture(pictureFile);
		var url= result.getData().get("url");
		//@SuppressWarnings("deprecation")
		//CV cV=this.cVDao.getOne(cVId);
		//Kullanımdan kaldırıldığı için bu şekilde devam ettim. Denenecek.
		CV cV=this.cVDao.getById(cVId);
		cV.setPictureUrl(url.toString());
        this.cVDao.save(cV);
		return new SuccessResult("Resminiz başarıyla eklendi.");
	}

}
