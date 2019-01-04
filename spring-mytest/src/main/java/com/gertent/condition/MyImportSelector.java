package com.gertent.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author wyf
 * @Date 2019/1/2 14:35
 * @Desc
 * @Version 1.0
 */
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.gertent.bean.Blue","com.gertent.bean.Yellow"};
    }
}
