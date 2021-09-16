package hrmsfullBackend.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.EducationService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Education;
import hrmsfullBackend.hrms.entities.dtos.addDtos.EducationAddDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@GetMapping("/getEducations")
	public DataResult<List<Education>> getEducations(){
		return this.educationService.getAllEducations();
	}
	
	@GetMapping("/getEducationsByCVId")
	public DataResult<List<Education>> getEducationsByCVId(@RequestParam int id){
		return this.educationService.getEducationByCVId(id);
	}
	
	@PostMapping("/addEducation")
	public Result addEducation(@RequestBody EducationAddDto education) {
		return this.educationService.addEducation(education);
	}
	
	@DeleteMapping("/deleteEducation")
	public Result deleteEducationById(@RequestBody int id) {
		return this.educationService.deleteEducationById(id);
	}
}
