package brussels.digitalcity.maxdolmans.demorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class BeanConfig {

    // Bean custom qui doit être créé dans une class de configuration
    @Bean
    public Scanner scan() {
        return new Scanner(System.in);
    }

}
