package com.qf.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 徐老板
 * @date 2020/2/9   15:40
 */
@SpringBootApplication
@EnableEurekaServer
@EnableWebSecurity
public class EurekaStarter extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(EurekaStarter.class,args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/eureka/**").permitAll()
                .anyRequest()
                .authenticated().and().httpBasic();

    }
}
