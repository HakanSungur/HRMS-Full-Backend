package hrmsfullBackend.hrms.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.JobExperienceService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobExperience;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobExperienceAddDto;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin

public class JobExperiencesController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getJobExperienceByCvId")
	public DataResult<List<JobExperience>> getJobExperienceByCvId(@RequestParam int cVId){
		return this.jobExperienceService.getJobExperienceByCvId(cVId);
	}
	
	@PostMapping("/addJobExperience")
	public Result addJobExperience(@RequestParam JobExperienceAddDto jobExperinence) {
		return this.jobExperienceService.addJobExperience(jobExperinence);
	}
	
	@DeleteMapping("/deleteJobExperienceById")
	public Result deleteJobExperienceById(@RequestParam int id) {
		return this.jobExperienceService.deleteJobExperienceById(id);
	}
	
}
