package ir.dotin.dotinspringdemo.aspect;

import ir.dotin.dotinspringdemo.exception.CustomRestException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* ir.dotin.dotinspringdemo.controller.*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint){
        Arrays.stream(joinPoint.getArgs()).forEach(o -> {
            System.out.println(o.getClass());
        });
        logger.info(joinPoint.getSignature().getName());
    }

//    @AfterReturning(value = "execution(* ir.dotin.dotinspringdemo.controller.*.*(..))"
//    ,returning = "result")
//    public void logAfterReturningExecution(JoinPoint joinPoint, Object result){
//        if(result instanceof ResponseEntity){
//            System.out.println(((ResponseEntity<?>) result).getStatusCode());
//        }
//    }

    @AfterThrowing(value = "execution(* ir.dotin.dotinspringdemo.controller.*.*(..))"
            ,throwing = "exception")
    public void logAfterThrowingExecution(JoinPoint joinPoint, Throwable exception){
        if(exception instanceof CustomRestException){
            logger.error(exception.getMessage());
        }
    }



}
