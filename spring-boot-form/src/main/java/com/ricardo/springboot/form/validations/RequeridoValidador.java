package com.ricardo.springboot.form.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.isEmpty() || value.isBlank()) {
							//!StringUtils.hasText(value) es lo mismo a isEmty y isBlank
			
			return false;
		}
		return true;
	}

}
