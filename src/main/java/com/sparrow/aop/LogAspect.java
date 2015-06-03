package com.sparrow.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jay
 * @time 2015年5月28日
 */
@Component
@Aspect
public class LogAspect {
	
	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Before("execution(* com.sparrow.controller.*.*(..))")
	public void beforeController(JoinPoint jp) {
		//String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // 获得方法名
		logger.info("》》》》》》》》》》》》》》》》》》》》》》》》》》》");
		//System.out.println("====位于：" + className);
		logger.info("====调用" + methodName + " 方法-开始！");
		Object[] args = jp.getArgs(); // 获得参数列表
		if (args.length <= 0) {
			logger.info("====" + methodName + "方法没有参数");
		} else {
			for (int i = 0; i < args.length; i++) {
				logger.info("====参数  " + (i + 1) + "：" + args[i]);
			}
		}
		logger.info("=====================================");
	}

	@After(value = "execution(* com.sparrow.controller.*.*(..))")
	public void afterController(JoinPoint jp) {
		logger.info("=====================================");
		logger.info("====" + jp.getSignature().getName() + " 方法-结束！");
		logger.info("《《《《《《《《《《《《《《《《《《《《《《《《《《《《");
	}
	
}
