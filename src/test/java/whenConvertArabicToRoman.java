import domain.Convert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class whenConvertArabicToRoman {
    @Test
    public void convert_0_to_emptyString() {
        assertEquals("", Convert.ToRoman(0));
    }

    @Test
    public void convert_1_to_I() {
        assertEquals("I", Convert.ToRoman(1));
    }

    @Test
    public void convert_2_to_II() {
        assertEquals("II", Convert.ToRoman(2));
    }

    @Test
    public void convert_3_to_III() {
        assertEquals("III", Convert.ToRoman(3));
    }

    @Test
    public void convert_5_to_V() {
        assertEquals("V", Convert.ToRoman(5));
    }

    @Test
    public void convert_6_to_VI() {
        assertEquals("VI", Convert.ToRoman(6));
    }

    @Test
    public void convert_10_to_X() {
        assertEquals("X", Convert.ToRoman(10));
    }
}
