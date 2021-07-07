package com.w2m.hero.heroservice.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
@Slf4j
public class TimedAspect {

    @Around("@annotation(TimedOut)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = point.proceed();
        stopWatch.stop();
        log.info("Clase: " + point.getSignature().getDeclaringType() + ". Método: " + point.getSignature().getName() + ". Tiempo de Ejecucion : " + (stopWatch.getTotalTimeMillis()) + " ms.");
        return object;
    }

}
