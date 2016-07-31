package com.qxh.maven.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qxh.maven.annotation.Limit;

@Aspect
@Component
public class LimitAspect {
	
	public void beforelimit(JoinPoint point, Limit limit) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		
		HttpServletRequest request = requestAttributes.getRequest();
		
		System.out.println("多少次：---- " +request.getRequestURL() + "-----" + limit.count());
	}
}
