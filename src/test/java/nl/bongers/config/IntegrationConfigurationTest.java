package nl.bongers.config;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class IntegrationConfigurationTest {

    @Test
    public void testIntegrationConfiguration() {
        final IntegrationConfiguration configuration = new IntegrationConfiguration();
        assertThat(configuration, notNullValue());
    }
}