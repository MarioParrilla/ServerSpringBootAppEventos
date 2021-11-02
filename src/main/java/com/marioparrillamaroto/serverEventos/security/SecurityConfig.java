package com.marioparrillamaroto.serverEventos.security;


import com.marioparrillamaroto.serverEventos.services.DetallesUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    @Qualifier("DetallesUsuarioService")
    private DetallesUsuarioService detallesUsuarioService;

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(detallesUsuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
        .authorizeRequests().antMatchers("/dist/**","/img/**","jsMyEventsApp/**","/plugins/**", "/error", "/soporte").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/**").hasAuthority("ADMIN")//.permitAll()
        .and().formLogin().loginPage("/login")
        .defaultSuccessUrl("/menu", true).permitAll()
        .and().logout().logoutUrl("/cerrarSesion").permitAll();

        http.exceptionHandling().accessDeniedPage("/login?noAcceso");
    }

}
