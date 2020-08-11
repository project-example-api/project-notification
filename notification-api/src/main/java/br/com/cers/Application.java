package br.com.cers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({ "br.com.cers" })
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Starting ServicesMainApplication...");

        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

}
