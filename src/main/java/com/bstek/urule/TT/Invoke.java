/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.bstek.urule.TT;

import com.bstek.urule.Utils;
import com.bstek.urule.entity.Customer;
import com.bstek.urule.runtime.*;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.math.RandomUtils;

import java.util.List;

/**
 * @author szh45242
 * @version $Id: Invoke.java, v0.1 2018/7/24 szh45242 Exp $$
 */
public class Invoke {
    public static void doTest() throws Exception{
        //从Spring中获取KnowledgeService接口实例
        KnowledgeService service=(KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //通过KnowledgeService接口获取指定的资源包"projectName/test123"
        KnowledgePackage knowledgePackage=service.getKnowledge("11/test");
        //通过取到的KnowledgePackage对象创建KnowledgeSession对象
        KnowledgeSession session= KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Customer customer=new Customer();
        customer.setAge(19);
        customer.setName("测试");
        customer.setGender(true);
        //将业务数据对象customer插入到KnowledgeSession中
        session.insert(customer);
        //执行所有满足条件的规则
        session.fireRules();
    }

    public static void doBatchTest() throws Exception{
        //从Spring中获取KnowledgeService接口实例
        KnowledgeService service=(KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //通过KnowledgeService接口获取指定的资源包"projectName/test123"
        KnowledgePackage knowledgePackage=service.getKnowledge("11/test");
        //通过取到的KnowledgePackage对象创建KnowledgeSession对象
        BatchSession batchSession= KnowledgeSessionFactory.newBatchSession(knowledgePackage,3,30000);
        List<Customer> customers= Lists.newArrayList();
        for (int i=3;i<30000;i++){
            Customer customer=new Customer();
            customer.setAge(RandomUtils.nextInt(100));
            customer.setName("测试");
            customers.add(customer);
        }
        long start=System.currentTimeMillis();
        for (final Customer c :customers){
            batchSession.addBusiness(new Business() {
                @Override
                public void execute(KnowledgeSession session) {
                    session.insert(c);
                    session.fireRules();
                }
            });
        }
        batchSession.waitForCompletion();
        System.out.println("total:"+(System.currentTimeMillis()-start)+"ms");
    }
}