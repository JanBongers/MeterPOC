package nl.bongers.barcode;

import static java.util.Objects.isNull;

final class BarcodeParserWater extends BarcodeParser {

    BarcodeParserWater(String barcode) {
        super(barcode);
    }

    @Override
    public String getBarcodeStart() {
        if (isNull(barcode())) return EMPTY;
        return barcode().substring(0, 3);
    }

    @Override
    public String getBarcodeEnd() {
        if (isNull(barcode())) return EMPTY;
        return barcode().substring(9, barcode().length());
    }

    @Override
    public int getBarcodeSerial() {
        if (isNull(barcode())) return 0;
        return Integer.valueOf(barcode().substring(3, 9));
    }
}