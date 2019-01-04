package com.gertent.config;

import com.gertent.bean.Man;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @Author wyf
 * @Date 2019/1/3 9:27
 * @Desc BeanDefinitionRegistryPostProcessor是BeanFactoryPostProcessor的子接口
 * BeanDefinitionRegistryPostProcessor接口中可以获取可以BeanDefinitionRegistry,BeanDefinitionRegistry可以用来动态注入bean
 * 要注入的bean可以使用BeanDefinitionBuilder来生成
 * 也可以使用AnnotationConfigApplicationContext对象的registerBeanDefinition方法来动态注入bean
 * @Version 1.0
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Man.class);
        builder.addPropertyValue("name","王五");
        builder.addPropertyValue("age", "30");
        beanDefinitionRegistry.registerBeanDefinition("man", builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
