package nl.bongers.messagebus;

import nl.bongers.messagebus.dto.Asset;
import nl.bongers.service.MeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static nl.bongers.messagebus.Channels.ASSET_GEPLAATST_VERZOEK;

@Service
public class EventConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MeterService meterService;

    @Inject
    public EventConsumer(MeterService meterService) {
        this.meterService = meterService;
    }

    @StreamListener(ASSET_GEPLAATST_VERZOEK)
    public void geplaatstVerzoek(final Asset asset) {
        log(ASSET_GEPLAATST_VERZOEK, asset);
        meterService.putMeterGeplaatst(asset);
    }

    private void log(final String channel, final Asset asset) {
        if (log.isDebugEnabled()) {
            log.debug("Received {}: {}", channel, asset.getBarcode());
        }
    }
}
