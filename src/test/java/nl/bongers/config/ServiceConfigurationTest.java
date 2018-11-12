package nl.bongers.config;

import nl.bongers.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class ServiceConfigurationTest {

    private LoginService loginService;

    @Before
    public void setUp() {
        this.loginService = Mockito.mock(LoginService.class);
    }

    @Test
    public void testServiceConfiguration() {
        final ServiceConfiguration configuration = new ServiceConfiguration(loginService);
        assertThat(configuration, notNullValue());
        assertThat(configuration.meterService(), notNullValue());
    }
}