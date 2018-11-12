package nl.bongers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.bongers.config.Credentials;
import nl.bongers.dto.AuthenticationDTO;
import nl.bongers.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.nonNull;

public class LoginService {

    private static Semaphore mutex = new Semaphore(1);

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final Credentials credentials;

    public LoginService(Credentials credentials) {
        this.credentials = credentials;
    }

    String getBaseUrl() {
        return credentials.getBaseUrl();
    }

    void releaseMutex() {
        mutex.release();
    }

    private void acquireMutex() throws InterruptedException {
        final boolean acquired = mutex.tryAcquire(5, TimeUnit.MINUTES);
        if (!acquired) {
            log.warn("Mutex acquire timeout! Forcing release of mutex...");
            releaseMutex();
        } else {
            log.debug("Mutex permit acquired");
        }
    }

    public AuthenticationDTO authenticate() {
        ResponseEntity<String> response = null;
        try {
            acquireMutex();
            response = ResponseResult.AUTH_RESULT;
        } catch (InterruptedException e) {
            log.warn("{}: {}", e.getCause(), e.getMessage());
            Thread.currentThread().interrupt();
        }
        return jsonToObject(response);
    }

    private AuthenticationDTO jsonToObject(ResponseEntity<String> response) {
        AuthenticationDTO dto = null;
        try {
            dto = nonNull(response) && nonNull(response.getBody()) ? new ObjectMapper().readValue(response.getBody(), AuthenticationDTO.class) : null;
        } catch (IOException e) {
            log.warn("Could not parse JSON to AuthenticationDTO: {}", response.getBody());
        }
        return dto;
    }
}