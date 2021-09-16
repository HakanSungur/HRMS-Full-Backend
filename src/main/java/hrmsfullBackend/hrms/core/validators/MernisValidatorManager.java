package hrmsfullBackend.hrms.core.validators;

import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.entities.concretes.JobSeeker;


@Service
public class MernisValidatorManager {

	public boolean isMernis(JobSeeker jobSeeker) {
		return jobSeeker.getIdentityNumber().length()==11;
	}
	
}
