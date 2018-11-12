package nl.bongers.barcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BarcodeGenerator {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String barcodeStart;
    private final String barcodeEnd;

    public BarcodeGenerator(final String barcodeStart, final String barcodeEnd) {
        this.barcodeStart = barcodeStart;
        this.barcodeEnd = barcodeEnd;
    }

    public List<String> generateBulk() {
        final List<String> barcodes = new ArrayList<>();

        final BarcodeParser parser = BarcodeParser.parse(barcodeStart);
        final int serialEnd = BarcodeParser.parse(barcodeEnd).getBarcodeSerial();
        int serialStart = parser.getBarcodeSerial();

        log.info("Start: {}; End: {}; Difference: {};", serialStart, serialEnd, (serialEnd - serialStart));
        if ((serialEnd - serialStart) <= 0) {
            return barcodes;
        }

        while (serialStart <= serialEnd) {
            String typeTrailing = parser.getBarcodeStart();
            final String value = parser.getBarcodeStart() + serialStart + parser.getBarcodeEnd();

            for (int i = value.length(); i < parser.getLenght(); i++) {
                typeTrailing = new StringBuilder(typeTrailing).append("0").toString();
            }

            final String barcode = typeTrailing + serialStart + parser.getBarcodeEnd();
            barcodes.add(barcode);
            serialStart++;
        }
        return barcodes;
    }
}
