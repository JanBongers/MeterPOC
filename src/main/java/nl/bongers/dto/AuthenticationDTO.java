package nl.bongers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationDTO {

    private final String guid;

    public AuthenticationDTO(@JsonProperty("authenticate") final String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }
}