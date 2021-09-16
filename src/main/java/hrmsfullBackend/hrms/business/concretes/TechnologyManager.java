package hrmsfullBackend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.business.absracts.TechnologyService;
import hrmsfullBackend.hrms.core.services.DtoConventerService;
import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.ErrorDataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.core.utilities.results.SuccessDataResult;
import hrmsfullBackend.hrms.core.utilities.results.SuccessResult;
import hrmsfullBackend.hrms.dataaccess.abstracts.TechnologyDao;
import hrmsfullBackend.hrms.entities.concretes.Technology;
import hrmsfullBackend.hrms.entities.dtos.addDtos.TechnologyAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;

@Service
public class TechnologyManager implements TechnologyService {
	
	private TechnologyDao technologyDao;
	private DtoConventerService dtoConventerService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, DtoConventerService dtoConventerService) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConventerService = dtoConventerService;
	}

	@Override
	public Result addTechnology(TechnologyAddDto technology) {
		this.technologyDao.save((Technology) this.dtoConventerService.dtoClassConverter(technology, Technology.class));
		return new SuccessResult("Programla dili eklendi!");
	}

	@Override
	public Result updateTechnology(TechnologyUpdateDto technology) {
		this.technologyDao.save((Technology) this.dtoConventerService.dtoClassConverter(technology, Technology.class));
		return new SuccessResult("Programla dili güncellendi!");
	}

	@Override
	public Result deleteTechnologyById(int id) {
		this.technologyDao.deleteById(id);
		return new SuccessResult("Programlama dili silindi!");
	}

	@Override
	public DataResult<List<Technology>> getTechnologies() {
		if(this.technologyDao.findAll().isEmpty()) {
			return new ErrorDataResult<List<Technology>>("Programlama dili bulunamadı!");
		}else {
			return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Programlama dilleri listelendi!");
			
		}
	}

	@Override
	public DataResult<List<Technology>> getTechnologieByCVId(int id) {
		if(this.technologyDao.getTechnologyByCVId(id).isEmpty()) {
			return new ErrorDataResult<List<Technology>>("Programlama dili bulunamadı!");
		}else {
			return new SuccessDataResult<List<Technology>>(this.technologyDao.getTechnologyByCVId(id), "Programlama dilleri listelendi!");
		}
	}
	

}
