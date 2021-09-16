package hrmsfullBackend.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsfullBackend.hrms.business.absracts.DeparmentService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Department;

@RestController
@RequestMapping("/api/deparments")
@CrossOrigin
public class DepartmentsController {

	private DeparmentService departmentService;

	@Autowired
	public DepartmentsController(DeparmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping("/getDeparments")
	public DataResult<List<Department>> getDepartments(){
		return this.departmentService.getDepartment();
	}
	
	@PostMapping("/addDepartment")
	public Result addDepartment(@RequestBody Department department) {
		return this.departmentService.addDepartment(department);
	}
	
}
