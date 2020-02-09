package com.algochimbita.aopexample.main;

import com.algochimbita.aopexample.delegate.UserDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String... args)  {
        System.out.printf("algo");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        UserDelegate userDelegate = ctx.getBean("userDelegate", UserDelegate.class);
        System.out.println(userDelegate.getUserInfo().toString());
        ctx.close();
    }
}
