package com.example.loginpage_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.example.loginpage_v1.*" })
public class LoginPageV1Application {

    public static void main(String[] args) {
        SpringApplication.run(LoginPageV1Application.class, args);
    }

}
