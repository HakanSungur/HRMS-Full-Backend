package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.Technology;
import hrmsfullBackend.hrms.entities.dtos.addDtos.TechnologyAddDto;
import hrmsfullBackend.hrms.entities.dtos.updateDtos.TechnologyUpdateDto;

public interface TechnologyService {

	Result addTechnology(TechnologyAddDto technology);
    Result updateTechnology(TechnologyUpdateDto technology);
    Result deleteTechnologyById(int id);
    DataResult<List<Technology>> getTechnologies();
    DataResult<List<Technology>> getTechnologieByCVId(int id);
}

