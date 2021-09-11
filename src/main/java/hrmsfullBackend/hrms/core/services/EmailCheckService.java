package hrmsfullBackend.hrms.core.services;

import hrmsfullBackend.hrms.entities.concretes.User;

public interface EmailCheckService {
	
	String emailValidator(User user);

}
