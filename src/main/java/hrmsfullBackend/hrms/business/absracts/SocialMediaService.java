package hrmsfullBackend.hrms.business.absracts;



import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.SocialMedia;
import hrmsfullBackend.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;

public interface SocialMediaService {

	Result addSocialMedia(SocialMediaAddDto socialMedia);
    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);
    DataResult <SocialMedia> getSocialMediaByCurriculaVitaeId(int id);
}
