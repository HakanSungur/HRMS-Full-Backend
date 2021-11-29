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

import hrmsfullBackend.hrms.business.absracts.JobAdvertService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.JobAdvert;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobAdvertAddDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getJobAdverts")
	public DataResult<List<JobAdvert>> getJobAdverts(){
		return this.jobAdvertService.getActiveJobAdverts();
	}
	
	@GetMapping("/getSortedJobAdverts")
	public DataResult<List<JobAdvert>> getSortedJobAdverts(){
		return this.jobAdvertService.getSortedJobAdverts();
	}
	
	@GetMapping("/getActiveJobAdverts")
	public DataResult<List<JobAdvert>> getActiveJobAdverts(){
		return this.jobAdvertService.getActiveJobAdverts();
	}
	
	@GetMapping("/getJobAdvertsBYCompanyName")
	public DataResult<List<JobAdvert>> getJobAdvertsBYCompanyName(String companyName){
		return this.jobAdvertService.getJobAdvertByCompanyName(companyName);
	}
	
	@GetMapping("/getJobAdvertByEmployerId")
	public DataResult<List<JobAdvert>> getJobAdvertByEmployerId(int id){
			return this.jobAdvertService.getJobAdvertByEmployerId(id);
	}
	
	@GetMapping("/getActiveJobAdvertsSorted")
	public DataResult<List<JobAdvert>> findAllByIsActiveTrueSorted(@RequestParam boolean isDesc ){
		return this.jobAdvertService.findAllByIsActiveTrue(isDesc);
	}
	
	@GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrue")
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(){
		return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue();
	}
	
	@GetMapping("/getActiveAndConfirmedJobAdvertCount")
	public int getActiveAndConfirmedJobAdvertCount() {
		if(Math.round((double) this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue().
				getData().size()/5)<1) {
			return 1;
		}else {
			return (int)Math.ceil((double) this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue().
					getData().size()/(double)5 );
		}
	}
	
	@GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc")
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(@RequestParam int pageNo, int pageSize){
		return this.getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(pageNo -1, pageSize);
	}
	
	@GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc")
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(@RequestParam int pageNo, int pageSize){
		return this.getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(pageNo -1, pageSize);
	}
	
	@GetMapping("getJobAdvertsById")
	public DataResult<JobAdvert> getJobAdvertsById(int id){
		return this.jobAdvertService.getJobAdvertById(id);
	}
	
	@DeleteMapping("/deleteJobAdvertById")
	public Result deleteJobAdvertById(@RequestParam int id) {
		return this.jobAdvertService.deleteJobAdvertById(id);
	}
	
	@PostMapping("/addJobAdvert")
	public Result addJobAdvert(@RequestParam JobAdvertAddDto jobAdvertAddDto) {
		return this.jobAdvertService.addJobAdvert(jobAdvertAddDto);
	}
}
