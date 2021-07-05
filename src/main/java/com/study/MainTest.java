package com.study;

import com.study.config.MainConfig;
import com.study.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-05 16:03
 **/
public class MainTest {
    public static void main(String[] args) {
/*        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
