package com.example.paymentservice.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@KeycloakConfiguration
@Import(KeycloakSpringBootConfigResolver.class)
public class KeyCloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired

   public void configureGlobal(AuthenticationManagerBuilder auth){
       CustomKeyCloakAuthProvider provider = new CustomKeyCloakAuthProvider();
       auth.authenticationProvider(provider);
   }
   @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    @Autowired
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      super.configure(http);

        System.out.println("entered configured method");
       http.csrf().disable()
               .cors().disable()
               .anonymous().disable()
               .authorizeRequests().anyRequest()
               .permitAll();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }
}
