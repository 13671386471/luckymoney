package com.imooc.kuckymoney.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 用于登陆校验的场景
 * */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.imooc.kuckymoney.controller.LuckymoneyController.*(..))")
   public void log(){

    }
    @Before("log()")
    //两个点意思是：无论是任何参数都会被拦截
    public void doBefore(JoinPoint joinPoint){
        logger.info("111111");
        System.out.println("被拦截了");
        //记录信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //****url
        logger.info("url={}", request.getRequestURL());
       //****method
        logger.info("method={}", request.getMethod());
        //****ip
        logger.info("ip={}", request.getRemoteAddr());
        //****类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        //****参数
        logger.info("args={}", joinPoint.getArgs());

    }
    @After("log()")
    public void doAfter(){
        logger.info("222222");
        System.out.println("拦截之后的内容");
    }
    @AfterReturning(returning="object", pointcut ="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}", object.toString());
    }
}
