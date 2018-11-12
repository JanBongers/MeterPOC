package nl.bongers.config;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class ServletConfigurationTest {

    @Test
    public void testServletConfiguration() {
        final ServletConfiguration configuration = new ServletConfiguration();
        assertThat(configuration, notNullValue());
        assertThat(configuration.containerCustomizer(), notNullValue());
    }
}