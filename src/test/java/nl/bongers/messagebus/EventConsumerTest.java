package nl.bongers.messagebus;

import nl.bongers.messagebus.dto.Asset;
import nl.bongers.service.MeterService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class EventConsumerTest {

    private MeterService meterService;
    private EventConsumer eventConsumer;
    private Asset asset;

    @Before
    public void setUp() {
        this.meterService = mock(MeterService.class);
        this.eventConsumer = new EventConsumer(meterService);
        this.asset = new Asset("1234", "login", "E654321");
    }

    @Test
    public void testGeplaatstVerzoek() {
        asset.setExternalRef("external");
        eventConsumer.geplaatstVerzoek(asset);
        verify(meterService, times(1)).putMeterGeplaatst(asset);
        verifyNoMoreInteractions(meterService);
    }
}