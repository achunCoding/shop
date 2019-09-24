package top.wycfight.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: wycfight@163.com
 * @description: 状态标记校验器
 * @create: 2019-04-14 12:11
 * @modify By:
 **/
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Integer> {
    private String[] values;
    @Override
    public void initialize(FlagValidator flagValidator) {
        this.values = flagValidator.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        for(int i=0;i<values.length;i++){
            if(values[i].equals(String.valueOf(value))){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
