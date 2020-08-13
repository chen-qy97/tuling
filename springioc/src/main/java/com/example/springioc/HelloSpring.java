package com.example.springioc;

public class HelloSpring {

    private String name;
    private int sex;
    /*依赖外部类  只要spring.xml中构建了Hi这个bean就可以*/
    private Hi hi;

    public HelloSpring(){

    }
    /*通过构造方法注入
    <bean class="com.example.springioc.HelloSpring" autowire="constructor">*/
    public HelloSpring(Hi hi){
        this.hi = hi;
    }

    public HelloSpring(String name,int sex){
        this.name = name;
        this.sex = sex;
    }

    public static HelloSpring build(String type){
        if("A".equals(type)){
            return new HelloSpring("liban", 1);
        }else if("B".equals(type)){
            return new HelloSpring("diaochan", 0);
        }else{
            throw new IllegalArgumentException("type must 'A' or 'B'");
        }
    }

}
