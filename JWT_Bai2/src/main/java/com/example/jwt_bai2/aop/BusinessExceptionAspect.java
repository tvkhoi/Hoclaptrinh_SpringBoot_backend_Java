package com.example.jwt_bai2.aop;

import com.example.jwt_bai2.entity.ReposeObject;
import com.example.jwt_bai2.services.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BusinessExceptionAspect {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Around("@annotation(com.example.jwt_bai2.aop.HandlBusinessException)")
    public Object handleBusinessLogicErrors(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (IllegalArgumentException ex) {
            logger.warn("Lỗi logic nghiệp vụ {}: {}", joinPoint.getSignature().getName(), ex.getMessage());
            return ResponseEntity.badRequest()
                    .body(new ReposeObject("400", "Lỗi nghiệp vụ", ex.getMessage()));
        }
    }
}
