package com.gertent.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public MyInstantiationAwareBeanPostProcessor(){
        System.out.println("MyInstantiationAwareBeanPostProcessor constructor...");
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor..............postProcessBeforeInstantiation--beanName:"+beanName+",beanClass:" +beanClass);
		return null;
	}

	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor..............postProcessAfterInstantiation--beanName:"+beanName+",bean:"+bean);
		return true;
	}

}

