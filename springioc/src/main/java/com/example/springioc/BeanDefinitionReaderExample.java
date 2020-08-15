package com.example.springioc;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Arrays;

public class BeanDefinitionReaderExample {

    public static void main(String[] args) {
        //注册中心
        BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();
        //读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(register);

        //资源读取器
        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("spring.xml");
        //装载 构建Bean定义
        reader.loadBeanDefinitions(resource);

        //bean的定义只能通过id来获取
        register.getAliases("hi");
        register.getBeanDefinition("hi");
        //register.getBeanDefinition("h2");  //报错，不能通过名称来获取
        System.out.println(Arrays.toString(register.getBeanDefinitionNames()));

    }

}
