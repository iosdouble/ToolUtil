package com.nh.code.web.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Classname NullAndRegexValid
 * @Description TODO
 * @Date 2019/8/20 2:25 PM
 * @Created by nihui
 */
@Constraint(
        validatedBy = {NullAndRegexValidator.class}
)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NullAndRegexValid {
    String message() default "{paramName}参数传递错误";

    String paramName() default "未知";

    String regex() default ".*";

    boolean notNull() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}