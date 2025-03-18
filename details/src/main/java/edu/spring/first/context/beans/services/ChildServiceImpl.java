package edu.spring.first.context.beans.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service()
public class ChildServiceImpl implements ChildService {

    @Resource(name = "second")
    private OtherInitStrategy ois;

    @Resource
    private MultiInstancesService multi;

    @PostConstruct
    public void init() {
        System.out.println("child initialization");
    }

    public void doSomething() {
        System.out.println("child something");
        ois.doSomethingToo();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("child destroy");
    }
}
