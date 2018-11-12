package nl.bongers.config;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class CredentialsTest {

    @Test
    public void testCredentials() {
        final Credentials credentials = new Credentials("base", "login", "pass");
        assertThat(credentials, notNullValue());
        assertThat(credentials.getBaseUrl(), is("base"));
        assertThat(credentials.getUsername(), is("login"));
        assertThat(credentials.getPassword(), is("pass"));
    }
}