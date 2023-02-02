package com.hang.people_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@MapperScan("com.hang.people_management.dao")
public class PeopleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeopleManagementApplication.class, args);
    }

}
