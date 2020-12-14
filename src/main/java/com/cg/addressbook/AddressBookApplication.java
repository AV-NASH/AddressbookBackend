package com.cg.addressbook;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Data
@SpringBootApplication
@Slf4j
public class AddressBookApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext=SpringApplication.run(AddressBookApplication.class, args);
     log.info("Addressbook started in {} env",applicationContext.getEnvironment().getProperty("environment") );
     log.info("addressbook DB user is {} ",applicationContext.getEnvironment().getProperty("spring.datasource.username"));
    }

}
