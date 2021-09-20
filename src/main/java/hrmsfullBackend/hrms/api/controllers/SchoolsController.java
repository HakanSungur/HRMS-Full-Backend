package hrmsfullBackend.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.SchoolService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getSchools")
	public DataResult<List<School>> getSchools(){
		return this.schoolService.getAllSchool();
	}
	@PostMapping("/addSchool")
	public Result addSchool(@RequestBody School school) {
		return this.schoolService.addSchool(school);
	}
	

}
