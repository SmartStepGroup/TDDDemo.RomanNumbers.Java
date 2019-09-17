import domain.Convert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class whenConvertArabicToRoman {
    @Test
    public void convert_0_to_emptyString() {
        assertEquals("", Convert.ToRoman(0));
    }
}
