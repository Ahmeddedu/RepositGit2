package edu.spring.first.context.beans.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MultiInstancesService {

    @PostConstruct
    public void init(){
        System.out.println("inited MULTI");
    }
}
