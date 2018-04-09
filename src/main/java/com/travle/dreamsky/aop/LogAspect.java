package com.travle.dreamsky.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志切面
 */
@Aspect
@Component
@Order(1) //当有多个Aspect指定该切面优先级最高，数字值越小，优先级越高
public class LogAspect {
    private final static Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * rest包和子包里面的所有方法
     */
    @Pointcut("execution(public * com.travle.dreamsky.web..*.*(..))")
    public void weblog(){
    }

    @Before("weblog()")
    /**
     * @Description
     * @param
     * @return
     */
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("请求类型 : " + request.getMethod());
        log.info("请求IP : " + request.getRemoteAddr());
        log.info("方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("参数列表 : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "weblog()") //ret要和形参中的ret保持一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("返回参数 : " + ret);
    }

}
