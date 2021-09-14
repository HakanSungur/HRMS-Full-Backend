package hrmsfullBackend.hrms.core.services;

import hrmsfullBackend.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {

	boolean isMernis(JobSeeker jobSeeker);
}
