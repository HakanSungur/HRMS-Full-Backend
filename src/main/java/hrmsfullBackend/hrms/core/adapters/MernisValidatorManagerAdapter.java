package hrmsfullBackend.hrms.core.adapters;

import hrmsfullBackend.hrms.core.services.MernisCheckService;
import hrmsfullBackend.hrms.core.validators.MernisValidatorManager;
import hrmsfullBackend.hrms.entities.concretes.JobSeeker;

public class MernisValidatorManagerAdapter implements MernisCheckService {

	private MernisValidatorManager mernisValidatorManager;

	public MernisValidatorManagerAdapter(MernisValidatorManager mernisValidatorMana) {
		super();
		this.mernisValidatorManager = mernisValidatorMana;
	}

	@Override
	public boolean isMernis(JobSeeker jobSeeker) {
		return this.mernisValidatorManager.isMernis(jobSeeker);
	}
	
}
