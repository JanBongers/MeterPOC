package nl.bongers.barcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BarcodeUtilTest {

    private static final String ELECTRIC_BARCODE = "E0025005000012215";
    private static final String GAS_BARCODE = "G0025005000012216";
    private static final String WATER_BARCODE = "17T12014903HVAAA";
    private static final String WATER_BARCODE_WHITESPACE_END = "17T12014906HVAAA ";
    private static final String WATER_BARCODE_WHITESPACE_START = " 17T12014906HVAAA";
    private static final String WATER_BARCODE_WHITESPACE_MID = "17T12014906 HVAAA";
    private static final String WATER_BARCODE_WHITESPACE_ALL = " 17T12014906 HVAAA ";

    @Test
    public void testIsElectricBarcode() {
        assertFalse(BarcodeUtil.isElectricBarcode(null));
        assertFalse(BarcodeUtil.isElectricBarcode(GAS_BARCODE));
        assertFalse(BarcodeUtil.isElectricBarcode(WATER_BARCODE));
        assertTrue(BarcodeUtil.isElectricBarcode(ELECTRIC_BARCODE));
    }

    @Test
    public void testIsGasBarcode() {
        assertFalse(BarcodeUtil.isGasBarcode(null));
        assertFalse(BarcodeUtil.isGasBarcode(ELECTRIC_BARCODE));
        assertFalse(BarcodeUtil.isGasBarcode(WATER_BARCODE));
        assertTrue(BarcodeUtil.isGasBarcode(GAS_BARCODE));
    }

    @Test
    public void testIsWaterBarcode() {
        assertFalse(BarcodeUtil.isWaterBarcode(null));
        assertFalse(BarcodeUtil.isWaterBarcode(ELECTRIC_BARCODE));
        assertFalse(BarcodeUtil.isWaterBarcode(GAS_BARCODE));
        assertTrue(BarcodeUtil.isWaterBarcode(WATER_BARCODE));
        assertTrue(BarcodeUtil.isWaterBarcode(WATER_BARCODE_WHITESPACE_END));
        assertTrue(BarcodeUtil.isWaterBarcode(WATER_BARCODE_WHITESPACE_START));
        assertTrue(BarcodeUtil.isWaterBarcode(WATER_BARCODE_WHITESPACE_MID));
        assertTrue(BarcodeUtil.isWaterBarcode(WATER_BARCODE_WHITESPACE_ALL));
    }
}