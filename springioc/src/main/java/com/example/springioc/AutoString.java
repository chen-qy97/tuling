package com.example.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class AutoString implements BeanFactoryAware {
    private BeanFactory beanFactory;

    public void sayHello(){
        beanFactory.getBean(Hi.class);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
