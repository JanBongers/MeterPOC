package nl.bongers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeterOverzichtDTO implements Serializable {

    private final String magazijncode;
    private final List<MeterDTO> data;

    public MeterOverzichtDTO(@JsonProperty("magazijncode") final String magazijncode,
                             @JsonProperty("data") final List<MeterDTO> data) {
        this.magazijncode = magazijncode;
        this.data = data;
    }

    public String getMagazijncode() {
        return magazijncode;
    }

    public List<MeterDTO> getData() {
        return data;
    }
}
