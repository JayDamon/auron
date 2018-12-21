package com.protean.security.auron.configuration;

import com.protean.security.auron.exception.AsyncExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AuronAsyncConfig implements AsyncConfigurer {

    private static Logger log = LoggerFactory.getLogger(AuronAsyncConfig.class);

    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int processors = Runtime.getRuntime().availableProcessors() + 1;
        log.info("Setting Executor pool size to " + processors);
        executor.setCorePoolSize(processors);
        executor.setMaxPoolSize(processors);
        executor.setThreadNamePrefix("Auron Executor-");
        executor.initialize();
        return executor;
    }
}
