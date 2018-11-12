package nl.bongers.barcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BarcodeParserTest {

    @Test
    public void testBarcodeParserElectric() {
        final BarcodeParser parser = BarcodeParser.parse("E0025005000012215");
        assertTrue(parser instanceof BarcodeParserElectricGas);
    }

    @Test
    public void testBarcodeParserGas() {
        final BarcodeParser parser = BarcodeParser.parse("G0025005000012316");
        assertTrue(parser instanceof BarcodeParserElectricGas);
    }

    @Test
    public void testBarcodeParserWater() {
        final BarcodeParser parser = BarcodeParser.parse("17T12014906HVAAA");
        assertTrue(parser instanceof BarcodeParserWater);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBarcodeParserNull() {
        BarcodeParser.parse(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testBarcodeParserUnknown() {
        BarcodeParser.parse("BARCODE");
    }
}