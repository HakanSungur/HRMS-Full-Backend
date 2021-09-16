package hrmsfullBackend.hrms.core.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.core.services.EmailCheckService;
import hrmsfullBackend.hrms.core.validators.EmailValidatorManager;
import hrmsfullBackend.hrms.entities.concretes.User;

@Service
public class EmailValidatorManagerAdapter implements EmailCheckService {

	private EmailValidatorManager emailValidatorManager;

	@Autowired
	public EmailValidatorManagerAdapter(EmailValidatorManager emailValidatorManager) {
		super();
		this.emailValidatorManager = emailValidatorManager;
	}

	@Override
	public String emailValidator(User user) {
		return this.emailValidatorManager.emailValidator(user);
	}
	
	
}
