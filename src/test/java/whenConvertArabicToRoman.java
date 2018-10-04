import domain.Convert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class whenConvertArabicToRoman {
    @Test
    public void convert_0_to_EmptyString() {
        assertEquals("", Convert.toRoman(0));
    }

    @Test
    public void Convert_1_to_I() {
        assertEquals("I", Convert.toRoman(1));
    }

    @Test
    public void Convert_2_to_II() {
        assertEquals("II", Convert.toRoman(2));
    }

    @Test
    public void Convert_5_to_V() {
        assertEquals("V", Convert.toRoman(5));
    }

    @Test
    public void Convert_8_to_VIII() {
        assertEquals("VIII", Convert.toRoman(8));
    }

    @Test
    public void Convert_4_to_IV() {
        assertEquals("IV", Convert.toRoman(4));
    }

    @Test
    public void Convert_9_to_IX() {
        assertEquals("IX", Convert.toRoman(9));
    }

    @Test
    public void Convert_90_to_XC() {
        assertEquals("XC", Convert.toRoman(90));
    }

    @Test
    public void Convert_2018_to_XC() {
        assertEquals("MMXVIII", Convert.toRoman(2018));
    }
}
