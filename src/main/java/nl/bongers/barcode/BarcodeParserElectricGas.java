package nl.bongers.barcode;

import static java.util.Objects.isNull;

final class BarcodeParserElectricGas extends BarcodeParser {

    BarcodeParserElectricGas(String barcode) {
        super(barcode);
    }

    @Override
    public String getBarcodeStart() {
        if (isNull(barcode())) return EMPTY;
        return barcode().substring(0, barcode().length() - 7);
    }

    @Override
    public String getBarcodeEnd() {
        if (isNull(barcode())) return EMPTY;
        return barcode().substring(barcode().length() - 2, barcode().length());
    }

    @Override
    public int getBarcodeSerial() {
        if (isNull(barcode())) return 0;
        return Integer.valueOf(barcode().substring(barcode().length() - 7, barcode().length() - 2));
    }
}