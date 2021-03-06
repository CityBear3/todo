package com.project.todo.utils.config

import com.project.todo.api.handler.*
import com.project.todo.domain.model.enum.RoleType
import com.project.todo.application.service.AuthenticationService
import com.project.todo.application.service.TodoAppUserDetailsService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@EnableWebSecurity
@Configuration
class SecurityConfig(private val authenticationService: AuthenticationService) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers("/api/login").permitAll()
            .mvcMatchers("/api/user/signup").permitAll()
            .mvcMatchers("/api/admin/**").hasAuthority(RoleType.ADMIN.toString())
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin()
            .loginProcessingUrl("/api/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .successHandler(TodoAppAuthenticationSuccessHandler())
            .failureHandler(TodoAppAuthenticationFailureHandler())
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(TodoAppAuthenticationEntryPoint())
            .accessDeniedHandler(TodoAppAccessDeniedHandler())
            .and()
            .logout()
            .logoutUrl("/api/logout")
            .logoutSuccessHandler(TodoAppLogoutSuccessHandler())
            .and()
            .cors().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(TodoAppUserDetailsService(authenticationService))
            .passwordEncoder(BCryptPasswordEncoder())
    }
}