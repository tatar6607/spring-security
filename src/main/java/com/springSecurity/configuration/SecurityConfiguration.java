package com.springSecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // webs security config adapter icerisindeki http securty configure methodunu override ediyorum
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll(); // tum herseye izin ver
        http
                .authorizeRequests()    // istekleri denetle
                .anyRequest()           // tum istekleri
                .authenticated()        // sifreli olarak kullan
                .and()                  // ve ile farkli islemleri bagla
                .formLogin()            // sifreleri form ile al
                .and()                  // ve ile farkli islemleri bagla
                .httpBasic();           // basic http kimlik denetimi
    }
}
