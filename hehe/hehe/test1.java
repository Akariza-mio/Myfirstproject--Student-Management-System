package com.xie.hehe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class test1 {
    public static String get_Verify_code(){
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        int numplace=r.nextInt(5);
        int thenum=r.nextInt(10);
        for(int i=0;i<5;++i){
            if(i!=numplace){
                int ch=r.nextInt(52);
                if(ch<26){
                    char tp=(char)(97+ch);
                    sb.append(tp);
                }else{
                    char tp=(char)(39+ch);
                    sb.append(tp);
                }
            }else{
                int n=r.nextInt(10);
                sb.append(n);
            }
        }
        return sb.toString();
    }
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
    public static void sign_menu(){
        System.out.println("--------mm的学生管理系统--------");
        System.out.println("         1.注册");
        System.out.println("         2.登录");
        System.out.println("         3.忘记密码");
        System.out.println("------------------------------");
        System.out.print("请输入您的选择:");
    }
    public static void sign_up(ArrayList<User> lu){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=sc.next();
        for(int i=0;i<lu.size();++i){
            if(lu.get(i).getUsername().equals(username)){
                System.out.println("用户名已存在,请重新输入");
                return;
            }
        }
        if(username.length()<3||username.length()>15){
            System.out.println("用户名长度应在3-15之间");
            return;
        }
        int cntnum=0,cntchar=0;
        for(int i=0;i<username.length();++i){
            char c=username.charAt(i);
            if((c<='z'&&c>='a')||(c<='Z'&&c>='A'))cntchar++;
            if(c<='9'&&c>='0')cntnum++;
        }
        if(cntchar+cntnum!=username.length()){
            System.out.println("用户名只能为数字和字母的组合");
            return;
        }
        if(cntnum==username.length()){
            System.out.println("用户名只能为数字和字母的组合");
            return;
        }
        if(cntchar==username.length()){
            System.out.println("用户名只能为数字和字母的组合");
            return;
        }
        System.out.println("请输入密码:");
        String password=sc.next();
        System.out.println("确认刚才的密码");
        String tp=sc.next();
        if(!tp.equals(password)){
            System.out.println("两次密码不一致");
            return;
        }
        System.out.println("请输入身份证号:");
        String id=sc.next();
        for(int i=0;i<lu.size();++i){
            if(lu.get(i).getId().equals(id)){
                System.out.println("身份证号已存在,请重新输入");
                return;
            }
        }
        if(id.length()!=18){
            System.out.println("身份证号应为18位");
            return;
        }
        if(id.charAt(0)=='0'){
            System.out.println("身份证号不能以0开头");
            return;
        }
        for(int i=0;i<17;++i) {
            char c=id.charAt(i);
            if(c>'9'||c<'0'){
                System.out.println("身份证号前17位应全为数字");
                return;
            }
        }
        if(id.charAt(17)!='X'&&(id.charAt(17)<'0'||id.charAt(17)>'9')){
            System.out.println("身份证号最后一位应为数字或X");
            return;
        }
        System.out.println("请输入手机号:");
        String phone=sc.next();
        if(phone.length()!=11) {
            System.out.println("手机号应为11位");
            return;
        }
        if(phone.charAt(0)=='0'){
            System.out.println("手机号不能以0开头");
            return;
        }
        for(int i=0;i<phone.length();++i) {
            char c=phone.charAt(i);
            if(c>'9'||c<'0'){
                System.out.println("手机号应全为数字");
                return;
            }
        }
        User u=new User(username,password,id,phone);
        lu.add(u);
        System.out.println("注册成功!");
    }
    public static boolean sign_in(ArrayList<User> lu){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.next();
        String real_password="";
        boolean find_user=false;
        for(int i=0;i<lu.size();++i){
            if(lu.get(i).getUsername().equals(username)){
                real_password=lu.get(i).getPassword();
                find_user=true;
                break;
            }
        }
        if(!find_user){
            System.out.println("用户未注册，请先注册");
            return false;
        }
        System.out.println("请输入密码：");
        String password=sc.next();
        System.out.println("输入验证码：");
        String vc=get_Verify_code();
        System.out.println(vc);
        String verify_code=sc.next();
        while(!vc.equals(verify_code)){
            System.out.println("验证码不正确，请重新输入：");
            verify_code=sc.next();
        }
        System.out.println("验证成功");
        for(int i=0;i<3;++i){
            if(i!=0)password=sc.next();
            if(real_password.equals(password)){
                System.out.println("密码正确，登录成功！");
                return true;
            }else{
                if(i==2){
                    System.out.println("密码错误，请重新登录！");
                    return false;
                }
                System.out.println("密码错误，还剩下"+(2-i)+"次机会");
                System.out.println("请再次输入密码：");
            }
        }
        return false;
    }
    public static void Forget(ArrayList<User> lu){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.next();
        boolean find_user=false;
        String real_id="";
        String real_phone="";
        int index=0;
        for(int i=0;i<lu.size();++i){
            if(lu.get(i).getUsername().equals(username)){
                find_user=true;
                real_id=lu.get(i).getId();
                real_phone=lu.get(i).getPhone();
                index=i;
                break;
            }
        }
        if(!find_user){
            System.out.println("用户未注册");
            return;
        }
        System.out.println("请输入身份证号码：");
        String id=sc.next();
        System.out.println("请输入电话号码：");
        String phone=sc.next();
        String newpassword="";
        if(id.equals(real_id)&&phone.equals(real_phone)){
            System.out.println("请输入新密码：");
            newpassword=sc.next();
            lu.get(index).setPassword(newpassword);
            System.out.println("修改成功！");
            return;
        }else{
            System.out.println("输入的信息不匹配");
            return;
        }
    }
    public static void main(String[] args) {
        //栈内存中的变量不会被默认初始化，调用方法时开辟栈内存
        ArrayList<Student> l=new ArrayList<>();
        ArrayList<User> lu=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        boolean d=false;
        while(d==false){
            sign_menu();
            int c=sc.nextInt();
            switch(c){
                case 1->sign_up(lu);
                case 2->{
                    d=sign_in(lu);
                }
                case 3->Forget(lu);
                default->System.out.println("没有这个操作");
            }
        }
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
