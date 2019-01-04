package com.gertent.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Set;

/**
 * @Author wyf
 * @Date 2019/1/3 9:47
 * @Desc 扫描注解bean
 * @Version 1.0
 */
public class MyBeanDefinitionRegistryPostProcessorEx implements BeanDefinitionRegistryPostProcessor {
    //1.0扫描指定包及其子包下面拥有指定注解的类
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        boolean useDefaultFilters = false;//是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
        String basePackage = "com.gertent.bean";
        ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
        //AnnotationTypeFilter是Spring自带的一个TypeFilter，可以扫描指定的注解。AnnotationTypeFilter一共有三个构造方法
        TypeFilter includeFilter = new AnnotationTypeFilter(ConfigAnnotation.class);
        beanScanner.addIncludeFilter(includeFilter);
        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
        for (BeanDefinition beanDefinition : beanDefinitions) {
            //beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
            //bean名称默认为全路径包名称+Bean名称
            String beanName = beanDefinition.getBeanClassName();
            registry.registerBeanDefinition(beanName, beanDefinition);
        }
    }

    //2.0扫描指定包及其子包下面的所有非接口和非抽象类
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        boolean useDefaultFilters = false;//是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
//        String basePackage = "com.gertent.bean";
//        ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
//        TypeFilter includeFilter = new TypeFilter() {
//            @Override
//            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
//                    throws IOException {
//                return metadataReader.getClassMetadata().isConcrete();
//            }
//        };
//        beanScanner.addIncludeFilter(includeFilter);
//        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
//        for (BeanDefinition beanDefinition : beanDefinitions) {
//            //beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
//            String beanName = beanDefinition.getBeanClassName();
//            registry.registerBeanDefinition(beanName, beanDefinition);
//        }
//    }


    //3.0 扫描指定包及其子包下面能赋值给指定Class的Class
    //  AssignableTypeFilter也是Spring内置的一个TypeFilter，用于扫描指定类型的类。只要目标类型能够赋值给指定的类型，则表示匹配。即如果指定的是一个接口，则所有直接或间接实现该接口的类都将被扫描到
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        boolean useDefaultFilters = false;//是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
//        String basePackage = "com.gertent.bean";
//        ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
//        //指定considerMetaAnnotations="true"时则如果目标类上没有指定的注解，但是目标类上的某个注解上加上了指定的注解则该类也将匹配。比如：
//        TypeFilter includeFilter = new AssignableTypeFilter(Hello.class);
//        beanScanner.addIncludeFilter(includeFilter);
//        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
//        for (BeanDefinition beanDefinition : beanDefinitions) {
//            //beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
//            String beanName = beanDefinition.getBeanClassName();
//            registry.registerBeanDefinition(beanName, beanDefinition);
//        }
//    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
