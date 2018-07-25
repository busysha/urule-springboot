/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.bstek.urule.rete;

import com.bstek.urule.action.ActionId;
import com.bstek.urule.entity.Customer;
import com.bstek.urule.model.ExposeAction;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author szh45242
 * @version $Id: MethodTest.java, v0.1 2018/7/23 szh45242 Exp $$
 */
public class MethodTest {
    @ActionId("helloKey")
    public String hello(String username){
        System.out.println("hello "+username);
        return "hello"+username;
    }
    @ExposeAction("helloTest")
    public void helloTest(String username){
        System.out.println("hello "+username);
    }

    @ExposeAction("测试Int")
    public int testInt(int a,int b){
        return a+b;
    }
    public int testInteger(Integer a,int b){
        return a+b*10;
    }

    @ExposeAction("打印内容")
    public void printContent(String username,Date birthday){
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(birthday!=null){
            System.out.println(username+"今年已经"+sd.format(birthday)+"岁了!");
        }else{
            System.out.println("Hello "+username+"");
        }
    }
    @ExposeAction("打印Member")
    public void printUser(Customer m){
        System.out.println("Hello "+m.getName()+", has house:"+m.isHouse());
    }
}