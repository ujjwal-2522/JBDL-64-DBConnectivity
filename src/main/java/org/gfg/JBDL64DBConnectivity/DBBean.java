package org.gfg.JBDL64DBConnectivity;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration//you have to use @Configuration when you use @Bean
public class DBBean {
//Createing bean of connection becoz connection is older class means read only file
    @Bean
    public Connection getConnection() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl_64","root","");
        return connection;
    }

    @Bean
    public DataSource getDB(){

        DataSourceBuilder builder= DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/jbdl_64");
        builder.username("root");
        builder.password("");
        return builder.build();

    }

}

