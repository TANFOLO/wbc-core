package main.java.com.wbc.core.validators;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.wbc.core.annotations.UUIDConstraint;

public class UUIDValidator implements ConstraintValidator<UUIDConstraint, String> {

	/**
	 * Logger de la classe
	 */
	private static Logger LOGGER = LogManager.getLogger(UUIDValidator.class);  

	@Override
	public void initialize(UUIDConstraint contactNumber) {
	}

	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {

		try{
			UUID uuid = UUID.fromString(contactField);
			return true;
		} catch (IllegalArgumentException e){
			LOGGER.error("Impossible de convertir " + contactField + " en UUID ", e);
		}

		return false;

	}

}