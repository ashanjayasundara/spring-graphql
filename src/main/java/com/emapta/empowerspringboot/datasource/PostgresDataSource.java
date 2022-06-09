package com.emapta.empowerspringboot.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * IoC: Inversion of Control : process in which an object defines its dependencies without creating them.This object delegates the job of
 * constructing such dependencies to an IoC container.
 */
@Configuration
public class PostgresDataSource {
  @Bean
  @ConfigurationProperties("app.datasource")
  public HikariDataSource hikariDataSource() {
    return DataSourceBuilder
      .create()
      .type(HikariDataSource.class)
      .build();
  }
}
