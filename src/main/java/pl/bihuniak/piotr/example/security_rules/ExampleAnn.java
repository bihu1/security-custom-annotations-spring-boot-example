package pl.bihuniak.piotr.example.security_rules;

import pl.bihuniak.piotr.example.user.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExampleAnn {
	Role role();
	String[] ids() default {};
	String order() default "PRE";
}
