package hrmsfullBackend.hrms.core.validators;



import org.springframework.stereotype.Service;

import hrmsfullBackend.hrms.entities.concretes.User;

@Service
public class EmailValidatorManager {

	public String emailValidator(User user) {
        return "Doğrulama kodu " + user.getEmail() + " adresine gönderildi";
        
    }
	
	 
}
