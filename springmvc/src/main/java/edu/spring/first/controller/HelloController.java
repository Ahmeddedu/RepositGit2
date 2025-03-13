package edu.spring.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, Spring Servlet App!";
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome"; // Resolves to /WEB-INF/views/welcome.jsp
    }
}