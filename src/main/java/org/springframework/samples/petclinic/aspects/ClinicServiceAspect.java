package org.springframework.samples.petclinic.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ClinicServiceAspect {
    final static Logger logger = LoggerFactory.getLogger(ClinicServiceAspect.class);
    
    @Before("target(org.springframework.samples.petclinic.service.ClinicService)")
    public void beforeServiceCall(JoinPoint jp) {
        logger.info("Clinic Service Method called: " + jp.getSignature().getDeclaringType().getName() + "." + jp.getSignature().getName());
    }
}
