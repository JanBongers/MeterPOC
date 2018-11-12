package nl.bongers.barcode;

import static java.util.Objects.nonNull;

final class BarcodeUtil {

    private BarcodeUtil() {}

    static boolean isElectricBarcode(String barcode) {
        return nonNull(barcode) && barcode.startsWith("E") && barcode.length() == 17;
    }

    static boolean isGasBarcode(String barcode) {
        return nonNull(barcode) && barcode.startsWith("G") && barcode.length() == 17;
    }

    static boolean isWaterBarcode(String barcode) {
        return nonNull(barcode) && barcode.replaceAll("\\s+", "").matches("^\\d{2}T[0-9a-zA-Z]*$") && barcode.replaceAll("\\s+", "").length() == 16;
    }
}