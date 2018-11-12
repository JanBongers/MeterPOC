package nl.bongers.api;

import nl.bongers.dto.MeterOverzichtDTO;
import nl.bongers.service.MeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MeterController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final MeterService meterService;

    @Inject
    public MeterController(MeterService meterService) {
        this.meterService = meterService;
    }

    @GetMapping(value = "/poc/meteroverzicht/{keyStatus}")
    public ResponseEntity<MeterOverzichtDTO> meteroverzicht(@PathVariable final int keyStatus) {
        log.debug("REST Request to GET meteroverzicht with keyStatus {}", keyStatus);

        final Optional<MeterOverzichtDTO> optional = meterService.getMeteroverzicht(keyStatus);
        final int size = optional.map(MeterOverzichtDTO::getData).map(List::size).orElse(0);
        log.info("Aantal meters met status {}: {}", keyStatus, size);
        return new ResponseEntity<>(optional.orElse(null), HttpStatus.OK);
    }

    @GetMapping(value = "/poc/bulk/{barcodeStart}/{barcodeEnd}")
    public ResponseEntity<List<String>> meterInboeken(@PathVariable final String barcodeStart, @PathVariable final String barcodeEnd) {
        log.debug("REST Request to generate barcodes. Start: {}, Eind: {}", barcodeStart, barcodeEnd);
        return meterService.generateBarcodes(barcodeStart, barcodeEnd);
    }
}