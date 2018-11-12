package nl.bongers.config.scheduler;

import nl.bongers.runnable.InboekenRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.inject.Inject;

public class ProductionScheduling implements SchedulingConfigurer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private InboekenRunnable inboekenRunnable;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        log.info("Configuring task(s) for Production.");
        configureCronTasks(scheduledTaskRegistrar);
    }

    private void configureCronTasks(final ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addCronTask(new CronTask(inboekenRunnable, "0 0/30 * * * *"));  //Alle hele en halve uren
    }
}