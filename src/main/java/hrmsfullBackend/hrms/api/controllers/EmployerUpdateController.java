package hrmsfullBackend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.EmployerUpdateService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employersupdate")
@CrossOrigin
public class EmployerUpdateController {

	private EmployerUpdateService employerUpdateService;

	@Autowired
	public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}
	
	@GetMapping("/getByEmployerUpdateId")
	public DataResult<EmployerUpdate> getEmployerUpdateById(int id){
		return this.employerUpdateService.getEmployerUpdateById(id);
	}
	
	@DeleteMapping("/deleteEmployerUpdateById")
	public Result deleteEmployerUpdateById(@RequestParam int id) {
		return this.employerUpdateService.deleteEmployerUpdateById(id);
	}
	
	@PostMapping("/addEmployerUpdate")
	public Result addEmployerUpdate(@RequestParam EmployerUpdate employerUpdate) {
		return this.employerUpdateService.addEmployerUpdate(employerUpdate);
	}
	
}
