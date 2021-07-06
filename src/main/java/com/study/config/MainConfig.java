package com.study.config;

import com.study.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-05 16:06
 **/
@Configuration
public class MainConfig {

    @Lazy
    @Bean(name = "person")
    public Person person() {
        System.out.println("向Spring容器中添加Person对象");
        return new Person("Moucc", 25);
    }

}
