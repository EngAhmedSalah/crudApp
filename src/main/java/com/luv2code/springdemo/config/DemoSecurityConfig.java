package com.luv2code.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {

        auth.inMemoryAuthentication()
                .withUser("user").password("root").roles("Employer")
                .and()
                .withUser("admin").password("root").roles("Admin" , "Employer")
                .and()
                .withUser("ahmed").password("root").roles("Manager" , "Admin" , "Employer");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.authorizeRequests()
//                .anyRequest().authenticated()
                .antMatchers("/").hasRole("Employer")
                .antMatchers("/customer/leader/**").hasRole("Manager")
                .antMatchers("/customer/system/**").hasRole("Admin")
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/customer/accessDenied");

    }

}





