package hrmsfullBackend.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.JobAdvertService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.JobAdvertDao;
import hrmsfullBackend.hrms.entities.concretes.JobAdvert;
import hrmsfullBackend.hrms.entities.dtos.addDtos.JobAdvertAddDto;

@Service
public class JobadvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	private DtoConventerService dtoConventerService;
	
	@Autowired
	public JobadvertManager(JobAdvertDao jobAdvertDao, DtoConventerService dtoConventerService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdverts() {
		if((long) this.jobAdvertDao.findAll().size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "Tüm iş ilanları listelendi.");
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş ilanı bulunamadı.");
		}
		
	}

	@Override
	public DataResult<List<JobAdvert>> getSortedJobAdverts() {
		Sort sort=Sort.by(Sort.Direction.ASC,"id");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort), "İş ilanları sıralandı.");
	}

	@Override
	public DataResult<List<JobAdvert>> getActiveJobAdverts() {
		if((long) this.jobAdvertDao.findAllByIsActiveTrue().size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByIsActiveTrue(), "Aktif iş ilanları listelendi.");
			
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş ilanları bulunamadı");
		}
		
		
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
		Sort sort=Sort.by(Sort.Direction.ASC,"id");
		if((long) this.jobAdvertDao.getJobAdvertByEmployer_CompanyName(companyName, sort).size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByEmployer_CompanyName(companyName, sort), "İş verene ait tüm ilanlar listelendi.");
		}else {
			return new ErrorDataResult<List<JobAdvert>>(companyName + "İş verenine ait ilanlar bulunamadı!");
		}
		
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByEmployerId(int employerId) {
		Sort sort=Sort.by(Sort.Direction.ASC,"isConfirmed","id");
		if((long) this.jobAdvertDao.getJobAdvertByEmployerId(employerId, sort).size()>0 ) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByEmployerId(employerId, sort), "İş verene ait tüm ilanlar listelendi.");
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş verene ait ilan bulunamadı!");
		}
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByIsActiveTrue(boolean isDesc) {
		Sort sort;
		if(isDesc) {
			sort=Sort.by(Sort.Direction.DESC,"airDate");
		}else {
			sort=Sort.by(Sort.Direction.ASC,"airDate");
		}
		if((long) this.jobAdvertDao.findAllByIsActiveTrue(sort).size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByIsActiveTrue(sort), "Tüm işler yayınlanma tarihine göre listelendi.");
			
		}else {
			return new ErrorDataResult<List<JobAdvert>>("İş ilanları listelenemedi!");
			
		}
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo,
			int pageSize) {
		
		Sort sort=Sort.by(Sort.Direction.DESC,"airDate");
		Pageable pageable=(Pageable) PageRequest.of(pageNo, pageSize,sort);
		
		if(this.jobAdvertDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable), "Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre azalarak listelendi!");
		}else {
			return new ErrorDataResult<List<JobAdvert>>("Onaylı ve aktif iş ilanı bulunamadı!");
		}
		
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize) {
		Sort sort=Sort.by(Sort.Direction.ASC,"airDate");
		Pageable pageable=(Pageable) PageRequest.of(pageNo, pageSize,sort);
		
		if(this.jobAdvertDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable), "Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre artarak listelendi!");
		}else {
			return new ErrorDataResult<List<JobAdvert>>("Onaylı ve aktif iş ilanı bulunamadı!");
		}
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
		if(this.jobAdvertDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue().size()>0) {
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(), "Onaylı ve Aktif tüm iş ilanları listelendi!");
		}else {
			return new ErrorDataResult<List<JobAdvert>>("Onaylı ve aktif iş ilanı bulunamadı!");
		}
	}

	@Override
	public DataResult<JobAdvert> getJobAdvertById(int id) {
		if(this.jobAdvertDao.getJobAdvertById(id)==null) {
			return new ErrorDataResult<JobAdvert>("İş ilanı bulunamadı!");
		}else {
			return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getJobAdvertById(id), "İş ilanı listelendi.");
		}
	}

	@Override
	public Result changeIsActive(boolean active, int id) {
		this.jobAdvertDao.changeIsActive(active, id);
		return new SuccessResult("İlan iktiflik durumu değiştirildi.");
	}

	@Override
	public Result changeIsConfirmed(boolean confirm, int id) {
		this.jobAdvertDao.changeIsConfirmed(confirm, id);
		return new SuccessResult("İlan onay durumu değiştirildi.");
	}

	@Override
	public Result addJobAdvert(JobAdvertAddDto jobAdvert) {
		this.jobAdvertDao.save((JobAdvert) this.dtoConventerService.dtoClassConverter(jobAdvert, JobAdvertAddDto.class));
		return new SuccessResult("İş ilanı kayıt edildi.");
	}

	@Override
	public Result deleteJobAdvertById(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi.");
	}

}
