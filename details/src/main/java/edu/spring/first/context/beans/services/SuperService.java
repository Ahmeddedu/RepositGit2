package edu.spring.first.context.beans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class SuperService {

    @Autowired
    private ChildService child;

    @Resource(name = "first")
    private OtherInitStrategy ois;

    @Resource
    private MultiInstancesService multi;

    @PostConstruct
    public void init() {
        System.out.println("super init");
    }

    public void doSomething() {
        System.out.println("super something");
        child.doSomething();
        ois.doSomethingToo();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("super destroy");
    }

    public void setChild(ChildServiceImpl child) {
        this.child = child;
    }
}
