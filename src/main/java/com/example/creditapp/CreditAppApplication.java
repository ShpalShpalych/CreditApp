package com.example.creditapp;

import com.example.creditapp.model.Employee;
import com.example.creditapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
@Configuration
public class CreditAppApplication implements CommandLineRunner, WebMvcConfigurer {

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(CreditAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String appUrl = "http://localhost:" + serverPort;
        System.out.println("Application is running at: " + appUrl);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/*");
    }
}
