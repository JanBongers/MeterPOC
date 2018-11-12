package nl.bongers.dto;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class MeterDTOTest {

    @Test
    public void testMeterDTO() {
        final MeterDTO meterDTO = new MeterDTO("MNR", "TYPE", 5, 12);
        assertThat(meterDTO, notNullValue());
        assertThat(meterDTO.getMeternummer(), is("MNR"));
        assertThat(meterDTO.getMeterType(), is("TYPE"));
        assertThat(meterDTO.getLeeftijd(), is(5));
        assertThat(meterDTO.getKeyMonteur(), is(12));
    }
}