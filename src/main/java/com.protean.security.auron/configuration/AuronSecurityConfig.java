package com.protean.security.auron.configuration;

import com.protean.security.auron.repository.UserRepository;
import com.protean.security.auron.security.JwtAuthenticationFilter;
import com.protean.security.auron.security.JwtTokenProvider;
import com.protean.security.auron.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;


public class AuronSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    
    public AuronSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean(name = "userDetailsService")
    public UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider,
                                                           UserDetailsServiceImpl userDetailsServiceImpl) {
        return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsServiceImpl);
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
