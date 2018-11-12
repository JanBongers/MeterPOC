package nl.bongers.barcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BarcodeGeneratorTest {

    @Test
    public void testBarcodeGeneratorGenerateBulkElectric() {
        final String barcodeStart = "E0025005000000115";
        final String barcodeEnd = "E0025005000015015";

        final BarcodeGenerator generator = new BarcodeGenerator(barcodeStart, barcodeEnd);
        final List<String> barcodes = generator.generateBulk();

        assertNotNull(barcodes);
        assertEquals(150, barcodes.size());
        assertEquals("E0025005000000115", barcodes.get(0));
        assertEquals("E0025005000005115", barcodes.get(50));
        assertEquals("E0025005000010115", barcodes.get(100));
        assertEquals("E0025005000015015", barcodes.get(barcodes.size() - 1));
    }

    @Test
    public void testBarcodeGeneratorGenerateBulkGas() {
        final String barcodeStart = "G0025005000120115";
        final String barcodeEnd = "G0025005000125015";

        final BarcodeGenerator generator = new BarcodeGenerator(barcodeStart, barcodeEnd);
        final List<String> barcodes = generator.generateBulk();

        assertNotNull(barcodes);
        assertEquals(50, barcodes.size());
        assertEquals("G0025005000120115", barcodes.get(0));
        assertEquals("G0025005000123115", barcodes.get(30));
        assertEquals("G0025005000125015", barcodes.get(barcodes.size() - 1));
    }

    @Test
    public void testBarcodeGeneratorGenerateBulkWater() {
        final String barcodeStart = "17T12000003HVAAA";
        final String barcodeEnd = "17T12014903HVAAA";

        final BarcodeGenerator generator = new BarcodeGenerator(barcodeStart, barcodeEnd);
        final List<String> barcodes = generator.generateBulk();

        assertNotNull(barcodes);
        assertEquals(150, barcodes.size());
        assertEquals("17T12000003HVAAA", barcodes.get(0));
        assertEquals("17T12005003HVAAA", barcodes.get(50));
        assertEquals("17T12010003HVAAA", barcodes.get(100));
        assertEquals("17T12014903HVAAA", barcodes.get(barcodes.size() - 1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBarcodeGeneratorUnknownBarcodes() {
        final BarcodeGenerator generator = new BarcodeGenerator("BARCODE", "BARCODE");
        generator.generateBulk();
    }
}