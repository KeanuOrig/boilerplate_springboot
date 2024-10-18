package com.example.demo.validator.annotations;

import com.example.demo.validator.impl.UniqueUsernameImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameImpl.class)
public @interface UniqueUsername {
    String message() default "Username is already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
