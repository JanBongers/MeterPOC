package nl.bongers.runnable;

import nl.bongers.dto.MeterDTO;
import nl.bongers.dto.MeterOverzichtDTO;
import nl.bongers.messagebus.EventGateway;
import nl.bongers.messagebus.dto.Asset;
import nl.bongers.service.MeterService;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InboekenRunnable implements Runnable {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MeterService meterService;
    private final EventGateway eventGateway;

    @Inject
    public InboekenRunnable(MeterService meterService, EventGateway eventGateway) {
        this.meterService = meterService;
        this.eventGateway = eventGateway;
    }

    @Override
    public void run() {
        log.info("Polling 'Te ontvangen' meters");

        final Optional<MeterOverzichtDTO> optional = meterService.getMeteroverzicht(10);
        final List<MeterDTO> inboekenList = new ArrayList<>();

        optional
                .ifPresent(meterOverzichtDTO -> Optional.of(meterOverzichtDTO.getData())
                .ifPresent(inboekenList::addAll));

        log.info("Registering {} assets as 'Te ontvangen'", inboekenList.size());

        try {
            inboekenList.forEach(meter -> {
                final Asset asset = new Asset("admin", meter.getMeternummer(), LocalDateTime.now().minusDays(meter.getLeeftijd()));
                eventGateway.inboeken(asset);
            });
        } catch (ResourceAccessException e) {
            log.warn("Receiving component offline. Doing nothing");
        }
    }
}
