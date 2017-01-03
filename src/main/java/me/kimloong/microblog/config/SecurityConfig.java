package me.kimloong.microblog.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author KimLoong
 */
//@EnableWebSecurity

//@EnableOAuth2Sso
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .formLogin().disable()
//                .authorizeRequests().anyRequest().authenticated();
//    }
}
