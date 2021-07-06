package com.study.config;

import com.study.condition.LinuxCondition;
import com.study.condition.WindowCondition;
import com.study.model.Person;
import org.springframework.context.annotation.*;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-05 16:06
 **/
@Configuration
@ComponentScan(basePackages = "com.study")
//@ComponentScan(basePackages = "com.study", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class, Service.class})}, useDefaultFilters = false)
//@ComponentScan(basePackages = "com.study", includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class, BookRepository.class})}, useDefaultFilters = false)
//@ComponentScan(basePackages = "com.study", includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})}, useDefaultFilters = false)
public class MainConfig {

    // @Lazy
    @Bean(name = "person")
    public Person person() {
        return new Person("Moucc", 25);
    }

    @Conditional({WindowCondition.class})
    @Bean(name = "personTest1")
    public Person person01() {
        return new Person("Test1", 20);
    }

    @Conditional({LinuxCondition.class})
    @Bean(name = "personTest2")
    public Person person02() {
        return new Person("Test2", 15);
    }

}
