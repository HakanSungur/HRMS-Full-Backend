package hrmsfullBackend.hrms.core.controllers;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmsfullBackend.hrms.business.absracts.EmployerService;
import hrmsfullBackend.hrms.business.absracts.JobAdvertService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {

	private EmployerService employerService;
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public EmployerController(EmployerService employerService, JobAdvertService jobAdvertService) {
		super();
		this.employerService = employerService;
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getEmployers")
	public DataResult<List<Employer>> getEmployers(){
		return this.employerService.getEmployers();
	}
	
	@GetMapping("/getEmployersById")
	public DataResult<Employer> getEmployerById(int id){
		return this.employerService.getEmployerById(id);
	}
	
	@DeleteMapping("/deleteEmployerById")
	public Result deleteEmployerById(@RequestParam int id) {
		return this.employerService.deleteEmployer(id);
	}
	
	@PostMapping("/addEmployer")
	public Result addEmployer(@RequestParam Employer employer) {
		return this.employerService.addEmployer(employer);
	}
	
	@PutMapping("/updateEmployer")
	public Result updateEmployer(@RequestParam Employer employer) {
		return this.employerService.updateEmployer(employer);
	}
	
	@PostMapping("/changeIsActive")
	public Result changeIsActive(@RequestParam boolean active, int jobAdvertId) {
		return this.jobAdvertService.changeIsActive(active, jobAdvertId);
	}
	
	@PostMapping("/changeIsUpdated")
	public Result changeIsUpdated (@RequestParam boolean update, int employerId) {
		return this.employerService.changeIsUpdated(update, employerId);
	}
	
	@PostMapping("/addPicture")
	public Result addPicture(int employerId, MultipartFile puctureFile) throws IOException {
		return this.employerService.uploadPicture(employerId, puctureFile);
	}
}
