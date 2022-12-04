package com.example.demoproweb.common;


import com.google.gson.Gson;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;


@Slf4j
@Component
@Aspect
public class ApiLogAspect {
    @Pointcut("@within(org.springframework.stereotype.Controller) && execution(* com.example.demoproweb.api..*(..))")
    public void apiLogAspect() {}

    @Around("apiLogAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        log.info("Request received...");
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object[] args = joinPoint.getArgs();
        AbstractBaseRequest request = Arrays.stream(args).filter(arg ->
                        Objects.nonNull(arg) && AbstractBaseRequest.class.isAssignableFrom(arg.getClass()))
                .map(arg -> (AbstractBaseRequest) arg)
                .findFirst().orElse(null);

        log.info("Request: {}", new Gson().toJson(request));
        long ts = System.currentTimeMillis();
        Object response = null;
        try {
            response = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            log.info("Request handled in {}ms...", System.currentTimeMillis() - ts);
        }

        return response;
    }
}
