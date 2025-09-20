package com.xie.hehe;

public class Student {
    //堆内存中的变量会被默认初始化，创建对象时开辟堆内存
    //一个对象实际上是一个引用，引用指向堆内存中的对象，修改后该地址的值会被跟着修改
    private String id;
    private String name;
    private int age;
    private String address;

    public Student(){}

    public Student(String id,String name,int age,String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}