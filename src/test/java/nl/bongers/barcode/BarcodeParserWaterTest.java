package nl.bongers.barcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarcodeParserWaterTest {

    @Test
    public void testBarcodeParserWaterBarcode() {
        final BarcodeParserWater parser = new BarcodeParserWater("17T12345603HVAAA");

        assertEquals("17T", parser.getBarcodeStart());
        assertEquals("03HVAAA", parser.getBarcodeEnd());
        assertEquals(123456, parser.getBarcodeSerial());
        assertEquals(16, parser.getLenght());
    }

    @Test
    public void testtestBarcodeParserWaterWithNull()  {
        final BarcodeParserWater parser = new BarcodeParserWater(null);

        assertEquals("", parser.getBarcodeEnd());
        assertEquals("", parser.getBarcodeStart());
        assertEquals(0, parser.getBarcodeSerial());
        assertEquals(0, parser.getLenght());
    }
}