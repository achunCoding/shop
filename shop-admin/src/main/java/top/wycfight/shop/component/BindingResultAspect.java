package top.wycfight.shop.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import top.wycfight.shop.common.api.CommonResult;

/**
 * @author: wycfight@163.com
 * @description: HibernateValidator错误结果处理切面
 * @create: 2019-09-25 11:20
 * @modified By:
 **/
@Aspect
@Component
@Order(2)
public class BindingResultAspect {
    @Pointcut("execution(public * top.wycfight.shop.controller.*.*(..))")
    public void bindingResult() {

    }

    @Around("bindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if (fieldError != null) {
                        return CommonResult.validateFailed(fieldError.getDefaultMessage());
                    } else {
                        return CommonResult.validateFailed();
                    }
                }
            }
        }
        return joinPoint.proceed();
    }
}
