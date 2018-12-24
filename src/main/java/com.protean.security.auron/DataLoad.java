package com.protean.security.auron;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataLoad {

    private DataSource dataSource;

    public DataLoad(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void loadTestUserData(DataSource dataSource) {
        Resource resource = new ClassPathResource("data-auron.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }
}
