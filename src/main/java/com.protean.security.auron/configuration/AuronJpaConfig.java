package com.protean.security.auron.configuration;

import com.protean.security.auron.security.JpaAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuronJpaConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new JpaAuditorAware();
    }

}
