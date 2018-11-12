package nl.bongers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.bongers.barcode.BarcodeGenerator;
import nl.bongers.dto.MeterOverzichtDTO;
import nl.bongers.messagebus.dto.Asset;
import nl.bongers.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MeterService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final LoginService loginService;

    public MeterService(LoginService loginService) {
        this.loginService = loginService;
    }

    public Optional<MeterOverzichtDTO> getMeteroverzicht(final int keyStatus) {
        final String guid = loginService.authenticate().getGuid();
        log.info("Meteroverzicht {} for guid: {}", keyStatus, guid);

        ResponseEntity<String> response = null;
        try {
            response = ResponseResult.METER_OVERZICHT;
        } catch (RestClientException e) {
            log.warn("{} {}: {}", keyStatus, e.getCause(), e.getMessage());
        } finally {
            loginService.releaseMutex();
            log.debug("Mutex permit released");
        }

        return Optional.ofNullable(jsonToObject(response));
    }

    public ResponseEntity<List<String>> generateBarcodes(final String barcodeStart, final String barcodeEnd) {
        final List<String> barcodeList = new BarcodeGenerator(barcodeStart, barcodeEnd).generateBulk();
        return new ResponseEntity<>(barcodeList, HttpStatus.OK);
    }

    public void putMeterGeplaatst(final Asset asset) {
        log.info("Meter {} geplaatst door {} bij {}", asset.getBarcode(), asset.getLogin(), asset.getExternalRef());
    }

    private MeterOverzichtDTO jsonToObject(ResponseEntity<String> response) {
        if (isNull(response)) {
            return null;
        }
        return readResponse(response);
    }

    private MeterOverzichtDTO readResponse(ResponseEntity<String> response) {
        try {
            return nonNull(response.getBody()) ? new ObjectMapper().readValue(response.getBody(), MeterOverzichtDTO.class) : null;
        } catch (IOException e) {
            log.warn("Could not parse JSON to MeterOverzichtDTO: {}", response.getBody());
        }
        return null;
    }
}