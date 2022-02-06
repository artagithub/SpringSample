package ir.dotin.dotinspringdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


public class JoinpointConfig {

    @Pointcut("@annotation(ir.dotin.dotinspringdemo.aspect.ExecutionTime)")
    public void logExecutionTimePointcut(){}

    @Pointcut("execution(* ir.dotin.dotinspringdemo.controller.*.*(..))")
    public void logAfterReturningExecution(){}

}
