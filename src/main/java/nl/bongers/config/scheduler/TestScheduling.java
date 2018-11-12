package nl.bongers.config.scheduler;

import nl.bongers.runnable.InboekenRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.inject.Inject;
import java.time.Duration;

public class TestScheduling implements SchedulingConfigurer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private InboekenRunnable inboekenRunnable;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        log.info("Configuring task(s) for test.");
        configureFixedRateTasks(scheduledTaskRegistrar);
    }

    private void configureFixedRateTasks(final ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addFixedRateTask(inboekenRunnable, Duration.ofMinutes(1).toMillis());
    }
}