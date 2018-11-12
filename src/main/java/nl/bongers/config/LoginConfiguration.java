package nl.bongers.config;

import nl.bongers.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguration {

    private final Credentials credentials;

    public LoginConfiguration(Credentials credentials) {
        this.credentials = credentials;
    }

    @Bean
    public LoginService loginService() {
        return new LoginService(credentials);
    }
}