package nl.bongers.api;

import nl.bongers.dto.AuthenticationDTO;
import nl.bongers.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final LoginService loginService;

    @Inject
    public AuthenticationController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/poc/authenticate")
    public ResponseEntity<AuthenticationDTO> authenticate() {
        log.debug("REST Request to authenticate");

        final AuthenticationDTO authenticationDTO = loginService.authenticate();
        return new ResponseEntity<>(authenticationDTO, HttpStatus.OK);
    }
}