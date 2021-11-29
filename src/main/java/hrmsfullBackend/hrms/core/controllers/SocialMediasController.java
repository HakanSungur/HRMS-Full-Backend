package hrmsfullBackend.hrms.core.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.SocialMediaService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.SocialMedia;
import hrmsfullBackend.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;

@RestController
@RequestMapping("/api/socialmedias")
@CrossOrigin
public class SocialMediasController {

	private SocialMediaService socialMediaService;
	
	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}


	@GetMapping("/getSocialMediaByCvId")
	public DataResult<SocialMedia> getSocialMediaByCvId(@RequestParam int cVId){
		return this.socialMediaService.getSocialMediaByCurriculaVitaeId(cVId);
	}
	
	@PostMapping("/addSocialMedia")
	public Result addSocialMedia(@RequestBody SocialMediaAddDto socialMedia) {
		return this.socialMediaService.addSocialMedia(socialMedia);
	}
	
	@PutMapping("/updateSocialMedia")
	public Result updateSocialMedia(@RequestBody SocialMediaUpdateDto socialMedia) {
		return this.socialMediaService.updateSocialMedia(socialMedia);
	}
}
