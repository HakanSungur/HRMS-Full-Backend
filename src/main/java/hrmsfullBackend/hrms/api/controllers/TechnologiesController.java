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

import hrmsfullBackend.hrms.business.absracts.TechnologyService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Technology;
import hrmsfullBackend.hrms.entities.dtos.addDtos.TechnologyAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getTehnologies")
	public DataResult<List<Technology>> getTehnologies(){
		return this.technologyService.getTechnologies();
	}
	
	@GetMapping("/getTechnologyByCvId")
	public DataResult<List<Technology>> getTechnologyByCvId(@RequestParam int cVId){
		return this.technologyService.getTechnologieByCVId(cVId);
	}
	
	@PostMapping("/addTechnology")
	public Result addTechnology(@RequestBody TechnologyAddDto technology) {
		return this.technologyService.addTechnology(technology);
	}
	
	@PutMapping("/updateTechnology")
	public Result updateTechnology(@RequestBody TechnologyUpdateDto technology) {
		return this.technologyService.updateTechnology(technology);
	}
	
	@DeleteMapping("/deleteTechnology")
	public Result deleteTechnology(@RequestParam int id) {
		return this.technologyService.deleteTechnologyById(id);
	}
}
