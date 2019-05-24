package com.protean.security.auron.bootstrap;

import com.protean.security.auron.AuronDataLoad;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile("test")
public class DataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private DataSource dataSource;

    public DataLoad(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Resource resource = new ClassPathResource("data-auron.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }
}
