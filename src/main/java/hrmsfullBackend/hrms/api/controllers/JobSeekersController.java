package hrmsfullBackend.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.JobSeekerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getJobSeekers")
	public DataResult<List<JobSeeker>> getJobSeekers(){
		return this.jobSeekerService.getJobSeekers();
	}
	
	@GetMapping("/getJobSeekerById")
	public DataResult<JobSeeker> getJobSeekerById(int id){
		return this.jobSeekerService.getJobSeekerById(id);
	}
	
	@PostMapping("/addJobSeeker")
	public Result addJobSeeker(@RequestParam JobSeeker jobSeeker) {
	    return	this.jobSeekerService.addJobSeeker(jobSeeker);
	}
	
	@DeleteMapping("/deleteJobSeekerById")
	public Result deleteJobSeekerById(@RequestParam int id) {
		return this.jobSeekerService.deleteJobSeekerById(id);
	}
	
}
