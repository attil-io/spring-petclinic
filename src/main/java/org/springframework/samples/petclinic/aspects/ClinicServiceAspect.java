package org.springframework.samples.petclinic.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ClinicServiceAspect {

    @Before("target(org.springframework.samples.petclinic.service.ClinicService)")
    public void beforeServiceCall(JoinPoint jp) {
        System.err.println("Clinic Service Method called: " + jp.getSignature().getDeclaringType().getName() + "." + jp.getSignature().getName());
    }
}
