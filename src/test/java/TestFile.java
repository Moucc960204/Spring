import com.alibaba.fastjson.JSONObject;
import com.study.config.MainConfig;
import com.study.model.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import javax.xml.transform.Source;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-06 09:40
 **/
public class TestFile {

    private static final Logger logger = LoggerFactory.getLogger(TestFile.class);

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Person person = (Person) applicationContext.getBean("person");
        logger.info("person==>{}", JSONObject.toJSONString(person));
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
        logger.info("person==>{}", JSONObject.toJSONString(person));
        Person person1 = applicationContext.getBean(Person.class);
        System.out.println(person1);
        logger.info("person1==>{}", JSONObject.toJSONString(person1));
        logger.info("person,person1==>{}", person == person1);
        String applicationName = applicationContext.getApplicationName();
        logger.info("applicationName==>{}", applicationName);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            logger.info("beanDefinitionName==>{}", beanDefinitionName);
        }
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNamesForType) {
            logger.info("beanName==>{}", beanName);
        }
        Environment environment = applicationContext.getEnvironment();
        logger.info("environment==>{}", JSONObject.toJSONString(environment));
        logger.info("osName==>{}", environment.getProperty("os.name"));
    }

}
