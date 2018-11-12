package nl.bongers.service;

import nl.bongers.dto.AuthenticationDTO;
import nl.bongers.dto.MeterDTO;
import nl.bongers.dto.MeterOverzichtDTO;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unchecked")
public class MeterServiceTest {

    private LoginService loginService;

    @Before
    public void setUp() {
        this.loginService = mock(LoginService.class);

        when(loginService.getBaseUrl()).thenReturn("http://127.0.0.1/");
        when(loginService.authenticate()).thenReturn(new AuthenticationDTO("GUID"));
    }

    @Test
    public void testMeteroverzicht() {
        final MeterService meterService = new MeterService(loginService);
        final MeterOverzichtDTO meteroverzicht = meterService.getMeteroverzicht(10).orElse(null);

        assertThat(meteroverzicht.getMagazijncode(), is("CODE_MAG"));
        assertThat(meteroverzicht.getData(), notNullValue());
        assertThat(meteroverzicht.getData(), hasSize(5));

        final MeterDTO meterDTO = meteroverzicht.getData().get(0);
        assertThat(meterDTO.getKeyMonteur(), is(2));
        assertThat(meterDTO.getMeternummer(), is("E0044007211174718"));
        assertThat(meterDTO.getMeterType(), is("Elektra"));
        assertThat(meterDTO.getLeeftijd(), is(12));
    }
}