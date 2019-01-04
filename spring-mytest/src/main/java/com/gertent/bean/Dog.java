package com.gertent.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog(){
        System.out.println("Dog---constructor---");
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog---PostConstruct---");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog---PreDestroy---");
    }
}
