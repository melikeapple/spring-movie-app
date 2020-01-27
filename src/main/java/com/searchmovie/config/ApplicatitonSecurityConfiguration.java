package com.searchmovie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class ApplicatitonSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //@Bean
    //public DaoAuthenticationProvider authenticationProvider(){
       // DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       // provider.setUserDetailsService(userDetailsService());
        //provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
       // return provider;
   // }

   // @Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // auth.authenticationProvider(authenticationProvider());
   // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users =new ArrayList<>();
        //User.UserBuilder users = User.withDefaultPasswordEncoder();
        users.add(User.withDefaultPasswordEncoder().username("melike").password("password").roles("USER").build());
        return new InMemoryUserDetailsManager(users);

    }




}
