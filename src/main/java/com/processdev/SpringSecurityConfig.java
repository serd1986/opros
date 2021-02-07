package com.processdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home", "/about", "/opros","/addOtvet").permitAll()
//                .antMatchers("/").hasAnyRole("ADMIN") //путь только для роли
//                .antMatchers("/zakazList").hasAnyRole("RASPIL")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
             //   .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/datepicker/**");
        web.ignoring().antMatchers("/dropdown/**");
        web.ignoring().antMatchers("/formoid/**");
        web.ignoring().antMatchers("/formstyler/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers("/mobirise/**");
        web.ignoring().antMatchers("/parallax/**");
        web.ignoring().antMatchers("/popper/**");
        web.ignoring().antMatchers("/smoothscroll/**");
        web.ignoring().antMatchers("/socicon/**");
        web.ignoring().antMatchers("/tether/**");
        web.ignoring().antMatchers("/theme/**");
        web.ignoring().antMatchers("/touchswipe/**");
        web.ignoring().antMatchers("/web/**");
        web.ignoring().antMatchers("/vue/**");
//        web.ignoring().antMatchers("/addOtvet");
//        web.ignoring().antMatchers("/opros");
    }
    // create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("username").password("password").roles("ADMIN");
    }
}