package hrmsfullBackend.hrms.core.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.business.absracts.CVService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.CV;
import hrmsfullBackend.hrms.entities.dtos.addDtos.CVAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.CVUpdateDto;

@RestController
@RequestMapping("api/cvs")
@CrossOrigin
public class CVsController {

	private CVService cVService;

	@Autowired
	public CVsController(CVService cVService) {
		super();
		this.cVService = cVService;
	}
	
	@GetMapping("/getCVWithJobSeekerId")
	public DataResult<CV> findCVByJobSeekerId(int id){
		return this.cVService.findByJobSeekerId(id);
	}
	
	@PostMapping("/addCV")
	public Result addCV(@RequestBody CVAddDto CV) {
		return this.cVService.addCv(CV);
	}
	
	@PutMapping("/updateCV")
	public Result updateCV(@RequestBody CVUpdateDto CV) {
		return this.cVService.updateCv(CV);
	}
	
	@PostMapping("/addPicture")
	public Result addPicture(int CVId, MultipartFile pictureFile) throws IOException {
		return this.cVService.uploadPicture(CVId, pictureFile);
	}
	
}
