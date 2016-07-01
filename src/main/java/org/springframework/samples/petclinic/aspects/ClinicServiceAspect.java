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
    public Object beforeServiceCall(ProceedingJoinPoint jp) throws Throwable {
        Object ret = null;
        logger.info("--> Clinic Service: " 
                + jp.getSignature().getDeclaringType().getName() 
                + "." + jp.getSignature().getName()
                + "(" + jp.getArgs() + ")");
        try {
            ret = jp.proceed();
            logger.info("<-- returned: " + ret);
        } catch (Exception e) {
            logger.info("<-- exception: " + e, e);
        }
        return ret;
    }
}
