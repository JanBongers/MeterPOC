package nl.bongers.dto;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class AuthenticationDTOTest {

    @Test
    public void testAuthenticationDTO() {
        final AuthenticationDTO authenticationDTO = new AuthenticationDTO("GUID");
        assertThat(authenticationDTO, notNullValue());
        assertThat(authenticationDTO, hasProperty("guid", equalTo("GUID")));
    }
}