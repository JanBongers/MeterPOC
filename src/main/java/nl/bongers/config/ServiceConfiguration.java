package nl.bongers.config;

import nl.bongers.service.LoginService;
import nl.bongers.service.MeterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    private final LoginService loginService;

    public ServiceConfiguration(LoginService loginService) {
        this.loginService = loginService;
    }

    @Bean
    public MeterService meterService() {
        return new MeterService(loginService);
    }
}