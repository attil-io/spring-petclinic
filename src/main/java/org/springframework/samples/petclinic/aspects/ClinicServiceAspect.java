package org.springframework.samples.petclinic.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ClinicServiceAspect {

    @Before("execution(** org.springframework.samples.petclinic.service.ClinicService.saveVisit(..))")
    public void beforeServiceCall() {
        System.err.println("save visit");
    }
}
