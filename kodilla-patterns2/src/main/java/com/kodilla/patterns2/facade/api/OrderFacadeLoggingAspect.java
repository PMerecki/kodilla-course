package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeLoggingAspect.class);

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logProcessOrder() {
        LOGGER.info("ProcessOrder method was called");
    }
}