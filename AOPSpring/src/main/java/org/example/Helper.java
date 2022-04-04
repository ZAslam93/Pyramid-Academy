package org.example;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {


    @Before("execution(public void show())")
    public void logOpen(){
        System.out.println("@Before Aspect");
    }
    @After("execution(public void show())")
    public void logClose(){
        System.out.println("@After Aspect");
    }



    @AfterReturning("execution(public void show())")
    public void afterReturn(){
        System.out.println("AfterReturning Aspect");
    }
    @AfterThrowing("execution(public void show())")
    public void afterThrow(){
        System.out.println("After show method due to Aspect");
    }
}
