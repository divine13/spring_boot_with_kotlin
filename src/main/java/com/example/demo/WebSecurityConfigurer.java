package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;

/**
 * Created by divine on 2017/06/09.
 */

@Configurable
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{

    @Inject
    private UserDetailsService userDetailsService;

    public WebSecurityConfigurer(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
  // when the password is sent we want o do some becrypt
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers("/**")
                .permitAll().antMatchers("/polls/**")
                .authenticated().and()
                .httpBasic().realmName("QuickPoll").and().csrf().disable();
    }
}
