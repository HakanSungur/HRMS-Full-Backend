package hrmsfullBackend.hrms.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.JobSeekerLanguageService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobSeekerLanguage;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

@RestController
@RequestMapping("/api/jobseekerlanguages")
public class JobSeekerLanguagesConroller {
	
	private JobSeekerLanguageService jobSeekerLanguageService;

	@Autowired
	public JobSeekerLanguagesConroller(JobSeekerLanguageService jobSeekerLanguageService) {
		super();
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}
	
	@GetMapping("/getJobSeekerLanguageByCVId")
	public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByCVId(@RequestParam int cVId){
		return this.jobSeekerLanguageService.getJobSeekerLanguageByCVId(cVId);
	}
	
	@PostMapping("/addJobSeekerLanguage")
	public Result addJobSeekerLanguage(@RequestParam JobSeekerLanguageAddDto jobSeekerLanguage) {
		return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
	}
	
	@DeleteMapping("deleteJobSeekerLanguageById")
	public Result deleteJobSeekerLanguageById(int id) {
		return this.jobSeekerLanguageService.deleteJobSeekerLanguageById(id);
	}

}
