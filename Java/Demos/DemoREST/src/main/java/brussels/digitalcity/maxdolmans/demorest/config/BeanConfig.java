package brussels.digitalcity.maxdolmans.demorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class BeanConfig {

    @Bean
    public Scanner scan() {
        return new Scanner(System.in);
    }

}
