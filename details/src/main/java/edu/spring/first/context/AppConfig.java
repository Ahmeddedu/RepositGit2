package edu.spring.first.context;


import edu.spring.first.context.beans.services.OtherInitStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.spring.first.context.beans") // Scans all components inside "com.example"
public class AppConfig {

    @Bean(initMethod = "init", name = "first")
    public OtherInitStrategy os1() {
        return new OtherInitStrategy("something1");
    }

    @Bean(initMethod = "init", name = "second")
    public OtherInitStrategy os2() {
        return new OtherInitStrategy("something2");
    }

}