package hrmsfullBackend.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.SocialMediaService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.SocialMediaDao;
import hrmsfullBackend.hrms.entities.concretes.SocialMedia;
import hrmsfullBackend.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;

@Service
public class SocialMediaManager implements SocialMediaService {
	
	private SocialMediaDao socialMediaDao;
	private DtoConventerService dtoConventerService;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao, DtoConventerService dtoConventerService) {
		super();
		this.socialMediaDao = socialMediaDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public Result addSocialMedia(SocialMediaAddDto socialMedia) {
		this.socialMediaDao.save((SocialMedia)this.dtoConventerService.dtoClassConverter(socialMedia, SocialMedia.class));
		return new SuccessResult("Sosyal medya bağlantıları sisteme eklendi!");
	}

	@Override
	public Result updateSocialMedia(SocialMediaUpdateDto socialMedia) {
		this.socialMediaDao.save((SocialMedia)this.dtoConventerService.dtoClassConverter(socialMedia, SocialMedia.class));
		return new SuccessResult("Sosyal medya bağlantıları güncellendi!");
	}

	@Override
	public DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id) {
		if(this.socialMediaDao.getSocialMediaByCVId(id)==null) {
			return new ErrorDataResult<SocialMedia>("Listelenecek sosyal medya bağlantısı bulunamadı!");
		}else {
			return new SuccessDataResult<SocialMedia>((SocialMedia)this.socialMediaDao.getSocialMediaByCVId(id) , null);
		}
	}
	
	

}
