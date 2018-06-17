
package com.webpage.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Connect {
    
    public DriverManagerDataSource conect(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/springmvc-001");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
    
}
