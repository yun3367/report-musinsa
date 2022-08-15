package com.musinsa.report;

import com.musinsa.report.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class ReportConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public BrandJdbcDao brandJdbcDao(JdbcTemplate jdbcTemplate) {
        NamedJdbcBrand namedJdbcBrand = new NamedJdbcBrand();
        namedJdbcBrand.setJdbcTemplate(jdbcTemplate);
        return namedJdbcBrand;
    }
}
