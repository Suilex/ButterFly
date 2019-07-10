package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*@Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSourse());
    }

    private DataSource getDataSourse() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:~/test86");
        dataSource.setUsername("username");
        dataSource.setPassword("");
        dataSource.setDriverClassName("org.h2.Driver");
        return null;
    }*/
}
