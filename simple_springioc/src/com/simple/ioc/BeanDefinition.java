package com.simple.ioc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanDefinition {

    private String beanId;

    private String beanClassName;

    private List<Map<String, String>> propertyList = new ArrayList<>();

    private Class<?> beanClass;

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
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

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
