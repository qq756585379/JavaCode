package com.simple.ioc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanDefinition {

    private String id;

    private String beanName;

    private List<Map<String, String>> propertyList = new ArrayList<>();

    private Class<?> beanClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public List<Map<String, String>> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Map<String, String>> propertyList) {
        this.propertyList = propertyList;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
