package com.tw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 系统日志，切面处理类
 *
 *
 */
@Aspect
@Component
public class SysLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
    /**
     * 切点
     */
    @Pointcut("@annotation(com.tw.annotation.SysLog)")
    public void logPointCut() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint 连接点
     */
    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        //请求的参数
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("当前登陆人：{},类名:{},方法名:{},参数：{},执行时间：{}", className, methodName, args, new Date());
    }

    @Pointcut("execution(public * com.tw.controller..*.*(..))")
    public void pointcutController() {}

    @Before("pointcutController()")
    public void around2(JoinPoint point) {
        //获取目标方法
        String methodNam = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();

        //获取方法参数
        String params = Arrays.toString(point.getArgs());

        logger.info("get in {} params :{}",methodNam,params);
    }

}
