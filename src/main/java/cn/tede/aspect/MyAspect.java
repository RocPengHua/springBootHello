package cn.tede.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by LYJ on 2017/6/1.
 */
@Component
@Aspect
public class MyAspect {

    @Before("execution(* cn.tede.service..*(..))")
    public void before(){
        System.out.println("我是一个前置通知");
    }
}


