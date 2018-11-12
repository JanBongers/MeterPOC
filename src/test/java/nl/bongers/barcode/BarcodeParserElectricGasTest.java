package nl.bongers.barcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarcodeParserElectricGasTest {

    @Test
    public void testBarcodeParserElectricGasWithElectricBarcode() {
        final BarcodeParserElectricGas parser = new BarcodeParserElectricGas("E0025005001699915");

        assertEquals("15", parser.getBarcodeEnd());
        assertEquals("E002500500", parser.getBarcodeStart());
        assertEquals(16999, parser.getBarcodeSerial());
        assertEquals(17, parser.getLenght());
    }

    @Test
    public void testBarcodeParserElectricGasWithElectricBarcodeTrailingZero() {
        final BarcodeParserElectricGas parser = new BarcodeParserElectricGas("E0025005000012215");

        assertEquals("15", parser.getBarcodeEnd());
        assertEquals("E002500500", parser.getBarcodeStart());
        assertEquals(122, parser.getBarcodeSerial());
        assertEquals(17, parser.getLenght());
    }

    @Test
    public void testBarcodeParserElectricGasWithGasBarcode() {
        final BarcodeParserElectricGas parser = new BarcodeParserElectricGas("G0025005001712316");

        assertEquals("16", parser.getBarcodeEnd());
        assertEquals("G002500500", parser.getBarcodeStart());
        assertEquals(17123, parser.getBarcodeSerial());
        assertEquals(17, parser.getLenght());
    }

    @Test
    public void testBarcodeParserElectricGasWithGasBarcodeTrailingZero() {
        final BarcodeParserElectricGas parser = new BarcodeParserElectricGas("G0025005000012316");

        assertEquals("16", parser.getBarcodeEnd());
        assertEquals("G002500500", parser.getBarcodeStart());
        assertEquals(123, parser.getBarcodeSerial());
        assertEquals(17, parser.getLenght());
    }

    @Test
    public void testBarcodeParserElectricGasWithNull() {
        final BarcodeParserElectricGas parser = new BarcodeParserElectricGas(null);

        assertEquals("", parser.getBarcodeEnd());
        assertEquals("", parser.getBarcodeStart());
        assertEquals(0, parser.getBarcodeSerial());
        assertEquals(0, parser.getLenght());
    }
}