package com.decipline.self.annotations.aspects;

import com.decipline.self.annotations.DefaultValueAnno;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class DefaultValueAspect {

    // Pointcut to target methods annotated with @PostConstruct
    @Pointcut("execution(@javax.annotation.PostConstruct * *(..))")
    public void postConstructMethods() {}

    @Before("postConstructMethods()")
    public void setDefaultValueIfNeeded(Object target) throws IllegalAccessException {
        // Reflect on all fields of the target class
        Field[] fields = target.getClass().getDeclaredFields();

        for (Field field : fields) {
            // Check if the field is annotated with @DefaultValueAnno
            if (field.isAnnotationPresent(DefaultValueAnno.class)) {
                DefaultValueAnno annotation = field.getAnnotation(DefaultValueAnno.class);
                String defaultValue = annotation.value();

                // Make the field accessible (in case it's private)
                field.setAccessible(true);

                // Check if the field value is null or empty
                Object fieldValue = field.get(target);
                if (fieldValue == null || "".equals(fieldValue)) {
                    // Set the default value
                    field.set(target, defaultValue);
                    System.out.println("Default value set for field " + field.getName() + ": " + defaultValue);
                }
            }
        }
    }
}
