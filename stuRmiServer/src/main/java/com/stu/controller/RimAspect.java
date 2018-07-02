package com.stu.controller;


import com.stu.model.MonitorAspectModel;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class RimAspect {

    static final Logger logger = Logger.getLogger(RimAspect.class);
    MonitorAspectModel mam = new MonitorAspectModel();

    @Around(value = "execution(* com.stu.service.impl.StudentServiceImpl.*(..))")
    public Object rmiServerRunlisner(ProceedingJoinPoint joinPoint) throws Throwable {

        mam.setClassName(joinPoint.getClass().getName());

        mam.setMethodName(joinPoint.getSignature().getName());

        mam.setStartTime(System.currentTimeMillis());

        mam.setStartDate(new Date());

        logger.info("StuServer RMI服务 开始执行远程方法调用,远程服务hostName："+ System.getProperty("java.rmi.server.hostname") + ", 调用方法：" + mam.getMethodName());

//        代理类 执行目标
        Object object = joinPoint.proceed();

        mam.setEndTime(System.currentTimeMillis());

        mam.setRunTime(mam.getStartTime()-mam.getEndTime());

        logger.info("远程方法" + System.getProperty("java.rmi.server.hostname") + " : " + mam.getMethodName() + " 调用结束");
        logger.info("运行时间：" + mam.getRunTime());

        return object;
    }


}
