package nl.bongers.config;

import nl.bongers.messagebus.Channels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;

@Configuration
@IntegrationComponentScan("nl.bongers.messagebus")
@EnableBinding(Channels.class)
public class IntegrationConfiguration {}
