package nl.bongers.messagebus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDateTime;

public class Asset {

    @JsonProperty("voorraadnummer")
    private String voorraadnummer;

    @JsonProperty("login")
    private String login;

    @JsonProperty("barcode")

    private String barcode;
    @JsonProperty("externalRef")
    private String externalRef;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Amsterdam")
    private LocalDateTime timestamp;

    @SuppressWarnings("unused")
    public Asset() {
        //JSON Serialize
    }

    public Asset(String voorraadnummer, String login, String barcode) {
        this.voorraadnummer = voorraadnummer;
        this.login = login;
        this.barcode = barcode;
    }

    public Asset(String login, String barcode, LocalDateTime timestamp) {
        this.login = login;
        this.barcode = barcode;
        this.timestamp = timestamp;
    }

    public String getVoorraadnummer() {
        return voorraadnummer;
    }

    public String getLogin() {
        return login;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getExternalRef() {
        return externalRef;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setVoorraadnummer(String voorraadnummer) {
        this.voorraadnummer = voorraadnummer;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}