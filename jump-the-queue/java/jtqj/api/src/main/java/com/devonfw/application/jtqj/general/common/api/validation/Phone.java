package com.devonfw.application.jtqj.general.common.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Pattern(regexp = "[0-9]{0,14}$", message = "Phone must be valid")
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface Phone {
  String message() default "Phone must be well formed";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}