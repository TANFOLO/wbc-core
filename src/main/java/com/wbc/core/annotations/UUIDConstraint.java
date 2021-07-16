package main.java.com.wbc.core.annotations;

import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Documented
@Constraint(validatedBy = main.java.com.wbc.core.validators.UUIDValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UUIDConstraint {
	
	@JsonProperty("measurementMetaData")
    String message() default "L'UUID est invalide";
	
	@JsonIgnoreProperties
    Class<?>[] groups() default {};
    
    @JsonIgnoreProperties
    Class<? extends Payload>[] payload() default {};
}