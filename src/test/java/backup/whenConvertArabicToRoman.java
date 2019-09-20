package backup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class whenConvertArabicToRoman {
    @Test
    public void convert_0_to_emptyString() {
        assertEquals("", Convert.toRoman(0));
    }

    @Test
    public void convert_1_to_I() {
        assertEquals("I", Convert.toRoman(1));
    }

    @Test
    public void convert_2_to_II() {
        assertEquals("II", Convert.toRoman(2));
    }

    @Test
    public void convert_3_to_III() {
        assertEquals("III", Convert.toRoman(3));
    }

    @Test
    public void convert_5_to_V() {
        assertEquals("V", Convert.toRoman(5));
    }

    @Test
    public void convert_6_to_VI() {
        assertEquals("VI", Convert.toRoman(6));
    }

    @Test
    public void convert_10_to_X() {
        assertEquals("X", Convert.toRoman(10));
    }

    @Test
    public void convert_13_to_XIII() {
        assertEquals("XIII", Convert.toRoman(13));
    }

    @Test
    public void convert_50_to_L() {
        assertEquals("L", Convert.toRoman(50));
    }

    @Test
    public void convert_16_to_XVI() {
        assertEquals("XVI", Convert.toRoman(16));
    }

    @Test
    public void convert_78_to_LXXVIII() {
        assertEquals("LXXVIII", Convert.toRoman(78));
    }

    @Test
    public void convert_4_to_IV() {
        assertEquals("IV", Convert.toRoman(4));
    }

    @Test
    public void convert_93_to_LXLIII() {
        assertEquals("LXLIII", Convert.toRoman(93));
    }

    @Test
    public void convert__to_LXLIII() {
        assertEquals("LXLIII", Convert.toRoman(93));
    }
}
