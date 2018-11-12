package nl.bongers.barcode;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static nl.bongers.barcode.BarcodeUtil.*;

public abstract class BarcodeParser {

    static final String EMPTY = "";

    private final String barcode;

    BarcodeParser(String barcode) {
        this.barcode = barcode;
    }

    String barcode() {
        return barcode;
    }

    public static BarcodeParser parse(String barcode) {
        BarcodeParser parser;
        if (isNull(barcode)) {
            throw new UnsupportedOperationException("Can not process null value");
        } else if (isWaterBarcode(barcode)) {
            parser = new BarcodeParserWater(barcode);
        } else if (isElectricBarcode(barcode) || isGasBarcode(barcode)) {
            parser = new BarcodeParserElectricGas(barcode);
        } else {
            throw new UnsupportedOperationException("Can not determine the type of the specified barcode: " + barcode);
        }
        return parser;
    }

    public int getLenght() {
        return nonNull(barcode) ? barcode.length() : 0;
    }

    public abstract String getBarcodeStart();

    public abstract String getBarcodeEnd();

    public abstract int getBarcodeSerial();
}
