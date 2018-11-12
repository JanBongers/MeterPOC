package nl.bongers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MeterDTO implements Serializable {

    private final String meternummer;
    private final String meterType;
    private final int leeftijd;
    private final int keyMonteur;

    public MeterDTO(@JsonProperty("Meternummer") final String meternummer,
                    @JsonProperty("MeterType") final String meterType,
                    @JsonProperty("Leeftijd") final int leeftijd,
                    @JsonProperty("keyMonteur") final int keyMonteur) {
        this.meternummer = meternummer;
        this.meterType = meterType;
        this.leeftijd = leeftijd;
        this.keyMonteur = keyMonteur;
    }

    public String getMeternummer() {
        return meternummer;
    }

    public String getMeterType() {
        return meterType;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public int getKeyMonteur() {
        return keyMonteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeterDTO meterDTO = (MeterDTO) o;
        return meternummer.equals(meterDTO.meternummer) && (meterType != null ? meterType.equals(meterDTO.meterType) : meterDTO.meterType == null);
    }

    @Override
    public int hashCode() {
        int result = meternummer.hashCode();
        result = 31 * result + (meterType != null ? meterType.hashCode() : 0);
        return result;
    }
}