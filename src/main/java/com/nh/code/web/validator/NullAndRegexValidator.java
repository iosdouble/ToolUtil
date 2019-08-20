package com.nh.code.web.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Classname NullAndRegexValidator
 * @Description TODO
 * @Date 2019/8/20 2:26 PM
 * @Created by nihui
 */
public class NullAndRegexValidator implements ConstraintValidator<NullAndRegexValid, Object> {
    private String paramName;
    private boolean notNull;
    private String regex;

    public NullAndRegexValidator() {
    }

    public void initialize(NullAndRegexValid constraintAnnotation) {
        this.paramName = constraintAnnotation.paramName();
        this.notNull = constraintAnnotation.notNull();
        this.regex = constraintAnnotation.regex();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        String valueStr;
        String message;
        if (this.notNull) {
            if (value == null) {
                valueStr = this.paramName + "不能为空";
                context.buildConstraintViolationWithTemplate(valueStr).addConstraintViolation();
                return false;
            }

            if (value.getClass() == String.class) {
                valueStr = value.toString();
                if (StringUtils.isBlank(valueStr)) {
                    message = this.paramName + "不能为空";
                    context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
                    return false;
                }
            }
        }

        if (value == null) {
            return true;
        } else {
            if (value.getClass() == String.class) {
                valueStr = value.toString();
                if (StringUtils.isBlank(valueStr)) {
                    return true;
                }
            }

            valueStr = value.toString();
            if (!valueStr.matches(this.regex)) {
                message = this.paramName + "的值不符合要求";
                context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
                return false;
            } else {
                return true;
            }
        }
    }
}
