package config;

import modele.Service5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Alternative à la déclaration dans applicationContext.xml

@Configuration
public class AppConfig {
    @Bean(name = "service5")
    public Service5 service5() {
        return new Service5();
    }

}
