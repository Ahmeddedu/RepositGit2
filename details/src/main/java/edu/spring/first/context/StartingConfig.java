package edu.spring.first.context;

import edu.spring.first.context.beans.services.ChildServiceImpl;
import edu.spring.first.context.beans.services.OtherInitStrategy;
import edu.spring.first.context.beans.services.SuperService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartingConfig {

    public static void main(String... args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        System.out.println(" ");
        System.out.println(" CONTEXT INITIATED");
        System.out.println(" ");

        SuperService myService = context.getBean(SuperService.class);

        myService.doSomething();

        System.out.println(" ");
        System.out.println(" CONTEXT CLOSING");
        System.out.println(" ");

        context.close();
    }

    public static void main1(String... args) {
        ChildServiceImpl c = new ChildServiceImpl();
        c.init();
        SuperService s = new SuperService();
        s.init();
        s.setChild(c);

        OtherInitStrategy ois = new OtherInitStrategy("");
        ois.init();

        s.doSomething();

        s.destroy();
        c.destroy();
    }
}
