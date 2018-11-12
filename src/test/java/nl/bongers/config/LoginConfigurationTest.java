package nl.bongers.config;

import nl.bongers.service.LoginService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;

public class LoginConfigurationTest {

    private Credentials credentials;

    @Before
    public void setUp() {
        this.credentials = mock(Credentials.class);
    }

    @Test
    public void testServiceConfigBean() {
        final LoginConfiguration configuration = new LoginConfiguration(credentials);
        final LoginService service = configuration.loginService();
        assertThat(service, notNullValue());
    }
}