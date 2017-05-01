package com.init;

import com.dao.DataAccess;
import com.service.CartService;
import com.service.ProductService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableConfigurationProperties
public class ApiConfiguration {

    @Bean
    ProductService productService() {
        return new ProductService();
    }

    @Bean
    CartService cartService() {
        return new CartService();
    }

    @Bean
    DataAccess productDAO() {
        return new DataAccess();
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public EmbeddedDatabase dataSource() {

        final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        final EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/create-tables.sql")
                .addScript("db/insert.sql")
                .build();
        return db;
    }

}
