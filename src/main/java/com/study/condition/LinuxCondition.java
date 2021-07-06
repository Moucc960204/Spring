package com.study.condition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-06 16:13
 **/
public class LinuxCondition implements Condition {

    private static final Logger logger = LoggerFactory.getLogger(LinuxCondition.class);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String systemName = environment.getProperty("os.name");
        logger.info("systemName==>{}", systemName);
        if (systemName.toLowerCase().contains("linux")) {
            return true;
        }
        return false;
    }
}
