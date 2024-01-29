package com.ricardo.springboot.form.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = IdentificadorRegexValidador.class )
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentificadorRegex {
	String message() default "identificador invalido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
