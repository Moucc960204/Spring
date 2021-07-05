package com.study.config;

import com.study.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-05 16:06
 **/
@Configuration
public class MainConfig {

    @Bean
    public Person person() {
        return new Person("chenchen", 25);
    }

}
