package com.study.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring-annotation
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-07 14:30
 **/
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[0];
        return new String[]{"com.study.model.Class"};
    }

}
