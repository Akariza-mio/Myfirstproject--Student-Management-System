package com.xie.hehe;

import java.util.ArrayList;
import java.util.Scanner;

public class test1 {
    public static void menu(){
        System.out.println("--------mm的学生管理系统--------");
        System.out.println("         1.添加学生");
        System.out.println("         2.删除学生");
        System.out.println("         3.修改学生");
        System.out.println("         4.查询学生");
        System.out.println("         5.退出系统");
        System.out.println("------------------------------");
        System.out.print("请输入您的选择:");
    }
    public static void addStu(ArrayList<Student> l){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入学生id:");
        String id=sc.next();
        System.out.print("请输入学生姓名:");
        String name=sc.next();
        System.out.print("请输入学生年龄:");
        int age=sc.nextInt();
        System.out.print("请输入学生地址:");
        String address=sc.next();
        Student s=new Student(id,name,age,address);
        l.add(s);
        System.out.println("添加成功!");
    }
    public static void deleteStu(ArrayList<Student> l){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入要删除的学生id:");
        String id=sc.next();
        for(int i=0;i<l.size();i++){
            if(l.get(i).getId().equals(id)){
                l.remove(i);
                System.out.println("删除成功!");
                return;
            }
        }
        System.out.println("该学生不存在!");
    }
    public static void modifyStu(ArrayList<Student> l){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要修改的学生id:");
        String id=sc.next();
        for(int i=0;i<l.size();++i){
            if(l.get(i).getId().equals(id)){
                System.out.print("输入新的学生姓名:");
                String name=sc.next();
                System.out.print("输入新的学生年龄:");
                int age=sc.nextInt();
                System.out.print("输入新的学生地址:");
                String address=sc.next();
                l.get(i).setName(name);
                l.get(i).setAge(age);
                l.get(i).setAddress(address);
                System.out.println("修改成功!");
                return;
            }
        }
        System.out.println("该学生不存在!");
    }
    public static void Stuinfo(ArrayList<Student> l){
        if(l.size()==0) System.out.println("没有任何学生信息");
        else{
            System.out.println("id\t姓名\t年龄\t地址");
            for(int i=0;i<l.size();++i){
                String id=l.get(i).getId();
                String name=l.get(i).getName();
                int age=l.get(i).getAge();
                String address=l.get(i).getAddress();
                System.out.printf("%s\t%s\t%d\t%s\n",id,name,age,address);
            }
        }
    }
    public static void main(String[] args) {
        //栈内存中的变量不会被默认初始化，调用方法时开辟栈内存
        ArrayList<Student> l=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int f=1;
        while(f==1){
            menu();
            int c=sc.nextInt();
            switch(c){
                case 1->addStu(l);
                case 2->deleteStu(l);
                case 3->modifyStu(l);
                case 4->Stuinfo(l);
                case 5->{
                    System.out.println("感谢使用!");
                    f=0;
                }
                default->System.out.println("没有这个操作");
            }
        }
    }
}
