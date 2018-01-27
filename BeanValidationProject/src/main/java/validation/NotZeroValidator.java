package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotZeroValidator implements ConstraintValidator<NotZero,Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return value==0;
	}

}
