package validation;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import model.User;

public class ValidationExample {
	
	
	public static void main(String[] args) {
		
		
		User user= new User();
		
		user.setUserName("user");
		user.setFirstName("Michal");
		user.setLastName("Kowalski");
		user.setAge(22);
		user.setBirthDate(new Date(Instant.now().toEpochMilli()));
		user.setEmail("adres");
		user.setPesel("23");
		user.setNotOddNumber(3);
		user.setNumber(5);
		
		
		ValidatorFactory buildDefaultValidatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = buildDefaultValidatorFactory.getValidator();
		Set<ConstraintViolation<User>> validate = validator.validate(user);
		for(ConstraintViolation<User> info:validate) {
			
			System.out.println("property path: "+info.getPropertyPath());
			System.out.println("error message: "+info.getMessage());
			System.out.println("invalid value: "+info.getInvalidValue());
		}
		
		
	}
}
