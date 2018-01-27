package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OddNumberValidator implements ConstraintValidator<OddNumber, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return value % 2 == 0;
	}

}
