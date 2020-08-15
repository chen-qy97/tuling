package com.example.springioc;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Arrays;

public class BeanFactoryExample {

    public static void main(String[] args) {
        //注册中心
        //BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.setResourceLoader(new DefaultResourceLoader());

        //装载 构建Bean定义
        reader.loadBeanDefinitions("spring.xml");

        factory.getBean("hi");
        factory.getBean("hi2");   //可以通过name来获取bean
        System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
    }

}
