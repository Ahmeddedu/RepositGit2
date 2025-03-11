package edu.articles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.articles") // Scans all components inside "com.example"
public class AppConfig {
}