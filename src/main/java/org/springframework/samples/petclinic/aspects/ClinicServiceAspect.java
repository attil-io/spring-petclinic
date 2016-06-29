package org.springframework.samples.petclinic.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ClinicServiceAspect {
    final static Logger logger = LoggerFactory.getLogger(ClinicServiceAspect.class);
    
    @Around("target(org.springframework.samples.petclinic.service.ClinicService)")
    public void beforeServiceCall(ProceedingJoinPoint jp) throws Throwable {
        logger.info("--> Clinic Service: " 
                + jp.getSignature().getDeclaringType().getName() 
                + "." + jp.getSignature().getName()
                + "(" + jp.getArgs() + ")");
        try {
            Object ret = jp.proceed();
            logger.info("<-- returned: " + ret);
        } catch (Exception e) {
            logger.info("<-- exception: " + e, e);
        }
    }
}
