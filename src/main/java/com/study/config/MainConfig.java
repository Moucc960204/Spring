package com.study.config;

import com.study.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-05 16:06
 **/
@Configuration
//@ComponentScan(basePackages = "com.study", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Service.class})}, useDefaultFilters = false)
//@ComponentScan(basePackages = "com.study", includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class, BookRepository.class})}, useDefaultFilters = false)
@ComponentScan(basePackages = "com.study", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})}, useDefaultFilters = false)
public class MainConfig {

//    @Lazy
    @Bean(name = "person")
    public Person person() {
        System.out.println("向Spring容器中添加Person对象");
        return new Person("Moucc", 25);
    }

}
