package hrmsfullBackend.hrms.business.absracts;

import java.util.List;

import hrmsfullBackend.hrms.core.utilities.results.DataResult;
import hrmsfullBackend.hrms.core.utilities.results.Result;
import hrmsfullBackend.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelService {

	DataResult<List<SystemPersonel>> getSystemPersonels();

    Result addSystemPersonel(SystemPersonel systemPersonel);

    Result updateSystemPersonel(SystemPersonel systemPersonel);

    DataResult<SystemPersonel> getSystemPersonelById(int id);

    Result deleteSystemPersonelById(int id);
}
