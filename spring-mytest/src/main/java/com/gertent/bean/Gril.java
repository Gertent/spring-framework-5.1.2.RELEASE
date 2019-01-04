package com.gertent.bean;

import com.gertent.config.ConfigAnnotation;

/**
 * @Author wyf
 * @Date 2019/1/3 9:29
 * @Desc
 * @Version 1.0
 */
@ConfigAnnotation
public class Gril {
    private String name;
    private String age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Gril [name=" + name + ", age=" + age + "]";
    }


}
