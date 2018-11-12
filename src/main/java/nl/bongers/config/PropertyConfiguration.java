package nl.bongers.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(final Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment, "cred.");
    }

    @Bean
    public Credentials cred() {
        return new Credentials(
                propertyResolver.getProperty("base-url"),
                propertyResolver.getProperty("username"),
                propertyResolver.getProperty("password")
        );
    }
}