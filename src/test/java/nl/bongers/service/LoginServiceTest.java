package nl.bongers.service;

import nl.bongers.config.Credentials;
import nl.bongers.dto.AuthenticationDTO;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SuppressWarnings("unchecked")
public class LoginServiceTest {

    @Test
    public void testAuthentication() {
        final Credentials credentials = new Credentials("http://127.0.0.1/", "login", "pass");
        final LoginService loginService = new LoginService(credentials);
        final AuthenticationDTO authenticationDTO = loginService.authenticate();
        loginService.releaseMutex();
        assertThat(authenticationDTO.getGuid(), is("8A19B879-E6AB-4316-9661-2039BE46F601"));
    }
}