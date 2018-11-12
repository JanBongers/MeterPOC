package nl.bongers.dto;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNull.notNullValue;

public class MeterOverzichtDTOTest {

    @Test
    public void testMeterOverzichtDTOEmptyCollection() {
        final MeterOverzichtDTO meteroverzichtDTO = new MeterOverzichtDTO("CODE", new ArrayList<>());
        assertThat(meteroverzichtDTO, notNullValue());
        assertThat(meteroverzichtDTO.getMagazijncode(), is("CODE"));
        assertThat(meteroverzichtDTO.getData(), allOf(notNullValue(), IsEmptyCollection.emptyCollectionOf(MeterDTO.class)));
    }

    @Test
    public void testMeterOverzichtDTOHasCollection() {
        final MeterDTO meterDTO = new MeterDTO("MNR", "TYPE", 5, 12);
        final MeterOverzichtDTO meteroverzichtDTO = new MeterOverzichtDTO("CODE", Collections.singletonList(meterDTO));
        assertThat(meteroverzichtDTO, notNullValue());
        assertThat(meteroverzichtDTO.getMagazijncode(), is("CODE"));
        assertThat(meteroverzichtDTO.getData(), allOf(notNullValue(), hasSize(1)));
        assertThat(meteroverzichtDTO.getData(), hasItem(meterDTO));
    }
}