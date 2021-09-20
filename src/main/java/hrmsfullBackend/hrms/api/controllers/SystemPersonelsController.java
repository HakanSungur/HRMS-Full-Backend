package hrmsfullBackend.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.EmployerService;
import hrmsfullBackend.hrms.business.absracts.JobAdvertService;
import hrmsfullBackend.hrms.business.absracts.SystemPersonelService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Employer;
import hrmsfullBackend.hrms.entities.concretes.SystemPersonel;

@RestController
@RequestMapping("/api/systempersonels")
@CrossOrigin
public class SystemPersonelsController {

	private SystemPersonelService systemPersonelService;
	private JobAdvertService jobAdvertService;
	private EmployerService employerService;
	
	@Autowired
	public SystemPersonelsController(SystemPersonelService systemPersonelService, JobAdvertService jobAdvertService,
			EmployerService employerService) {
		super();
		this.systemPersonelService = systemPersonelService;
		this.jobAdvertService = jobAdvertService;
		this.employerService = employerService;
	}
	
	@GetMapping("/getSystemPersonels")
	public DataResult<List<SystemPersonel>> getSystemPersonels(){
		return this.systemPersonelService.getSystemPersonels();
	}
	
	@GetMapping("/getSystemPersonelById")
	public DataResult<SystemPersonel> getSystemPersonelById(int id){
		return this.systemPersonelService.getSystemPersonelById(id);
	}
	
	@GetMapping ("/getEmployerByUpdatedTrue")
	public DataResult<List<Employer>> getEmployerByUpdatedTrue(){
		return this.employerService.getEmployerByUpdatedTrue();
	}
	
	@PostMapping("/addSystemPersonel")
	public Result addSystemPersonel(SystemPersonel systemPersonel) {
		return this.systemPersonelService.addSystemPersonel(systemPersonel);
	}
	
	@DeleteMapping("/deleteSystemPersonelById")
	public Result deleteSystemPersonelById(@RequestParam int id) {
		return this.systemPersonelService.deleteSystemPersonelById(id);
	}
	
	@PutMapping("/updateSystemPersonel")
	public Result updateSystemPersonel(@RequestBody SystemPersonel systemPersonel) {
		return this.systemPersonelService.updateSystemPersonel(systemPersonel);
	}
	
	@PostMapping("/changeConfirmed")
	public Result changeConfirmed(@RequestParam boolean confirm, int jobAdvertId ) {
		return this.jobAdvertService.changeIsConfirmed(confirm, jobAdvertId);
	}
}
