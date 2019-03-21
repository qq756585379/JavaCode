package com.simple.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IocTest {

    private static final Map<String, Object> beanMap = new ConcurrentHashMap<>();

    private static final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String path = "/Users/yangjun/Desktop/yangjun/github/Java/JavaCode/simple_springioc/src/com/simple/ioc/ioc_1.xml";
        new IocTest(path);

        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if (entry.getValue() instanceof User) {
                User user = (User) entry.getValue();
                System.out.println("userId:" + user.getId());
                System.out.println("userName:" + user.getName());
                System.out.println("userRoleName:" + user.getRole().getName());
            } else {
                Role role = (Role) entry.getValue();
                System.out.println("roleId:" + role.getId());
                System.out.println("roleName:" + role.getName());
            }
            System.out.println("-----------------");
        }
    }

    public IocTest(String path) throws Exception {
        loadBeans(path);
    }

    private void loadBeans(String location) throws Exception {
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            BeanDefinition beanDefinition = new BeanDefinition();

            if (node instanceof Element) {
                Element ele = (Element) node;
                String beanId = ele.getAttribute("id");
                String beanClassName = ele.getAttribute("class");

                beanDefinition.setBeanId(beanId);
                beanDefinition.setBeanClassName(beanClassName);

                List<Map<String, String>> propertyList = new ArrayList<>();
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Map<String, String> propertyMap = new HashMap<>();
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        propertyMap.put("propertyName", name);
                        if (value != null && value.length() > 0) {
                            propertyMap.put("propertyValue", value);
                            propertyMap.put("propertyType", "string");
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            propertyMap.put("propertyValue", ref);
                            propertyMap.put("propertyType", "ref");
                        }
                    }
                    propertyList.add(propertyMap);
                }
                beanDefinition.setPropertyList(propertyList);
                beanDefinition.setBeanClass(getBeanClass(beanClassName));
                beanDefinitionMap.put(beanId, beanDefinition);
            }
        }

        doLoadBeanDefinitions();
    }

    private void doLoadBeanDefinitions() throws Exception {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanId = entry.getKey();
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
            Object object = doGetBean(beanDefinition);
            if (object != null) {
                beanMap.put(beanId, object);
            }
        }
    }

    private Object doGetBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = beanMap.get(beanDefinition.getBeanId());
        if (bean == null) {
            bean = beanDefinition.getBeanClass().newInstance();
            populateBean(bean, beanDefinition.getPropertyList());
        }
        return bean;
    }

    private void populateBean(Object bean, List<Map<String, String>> pvs) throws Exception {
        for (Map<String, String> property : pvs) {
            String propName = property.get("propertyName");
            String propValue = property.get("propertyValue");
            String propType = property.get("propertyType");

            Field declaredField = bean.getClass().getDeclaredField(propName);
            declaredField.setAccessible(true);
            if ("string".equals(propType)) {
                declaredField.set(bean, propValue);
            } else {
                Object beanObject = beanMap.get(propValue);//ref
                if (beanObject != null) {
                    declaredField.set(bean, beanObject);
                } else {
                    Object refBean = doGetBean(beanDefinitionMap.get(propValue));
                    declaredField.set(bean, refBean);
                }
            }
        }
    }

    private Class<?> getBeanClass(String className) {
        Class<?> beanClass = null;
        try {
            beanClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return beanClass;
    }
}
