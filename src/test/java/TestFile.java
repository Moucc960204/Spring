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

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-06 09:40
 **/
public class TestFile {

    private static final Logger logger = LoggerFactory.getLogger(TestFile.class);

    /**
     * 通过xml配置加载bean
     */
    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Person person = (Person) applicationContext.getBean("person");
        logger.info("person==>{}", JSONObject.toJSONString(person));
    }

    /**
     * 通过注解配置加载bean
     */
    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
        logger.info("person==>{}", JSONObject.toJSONString(person));
        Person person1 = applicationContext.getBean(Person.class);
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
    }

    /**
     * 通过xml配置包扫描
     */
    @Test
    public void test03() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            logger.info("beanDefinitionName==>{}", beanDefinitionName);
        }

        Environment environment = applicationContext.getEnvironment();
        logger.info("environment==>{}", JSONObject.toJSONString(environment));
        logger.info("osName==>{}", environment.getProperty("os.name"));
    }

    /**
     * 通过注解配置包扫描
     */
    @Test
    public void test04() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            logger.info("beanDefinitionName==>{}", beanDefinitionName);
        }

        Environment environment = applicationContext.getEnvironment();
        logger.info("environment==>{}", JSONObject.toJSONString(environment));
        logger.info("osName==>{}", environment.getProperty("os.name"));
    }

    /**
     * 延迟加载 只针对单例模式有效
     */
    @Test
    public void test05() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        logger.info("ioc容器创建完成");
        Person person = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        logger.info("person,person2==>{}", person == person2);
    }

}
