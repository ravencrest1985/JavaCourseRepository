package validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=NotZeroValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotZero {
	
String message() default "not a zero";
Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default{};
int by() default 1;
}
