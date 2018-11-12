package nl.bongers.config;

import nl.bongers.config.scheduler.ProductionScheduling;
import nl.bongers.config.scheduler.TestScheduling;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.SchedulingConfigurer;

@Configuration
public class SchedulerConfiguration {

    @Bean
    @Profile({Constants.SPRING_PROFILE_PRODUCTION, Constants.SPRING_PROFILE_TEST, Constants.SPRING_PROFILE_STAGING})
    SchedulingConfigurer getProductionScheduler() {
        return new ProductionScheduling();
    }

    @Bean
    @Profile({Constants.SPRING_PROFILE_DEVELOPMENT})
    SchedulingConfigurer getTestScheduler() {
        return new TestScheduling();
    }
}