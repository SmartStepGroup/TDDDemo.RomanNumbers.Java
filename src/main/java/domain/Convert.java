package domain;

public class Convert {
    private static DigitsMap2 digitsMap = new DigitsMap2();

    public static String ToRoman(int arabic) {
        for (int i = 0; i < digitsMap.size(); i++) {
            int arabicDigit = digitsMap.arabicDigit(i);
            char romanDigit = digitsMap.romanDigit(i);
            if (arabicDigit <= arabic) {
                return romanDigit + getSimpleRomanNumber(arabic - arabicDigit);
            }
        }

        return getSimpleRomanNumber(arabic);
    }

    private static String getSimpleRomanNumber(int arabic) {
        return "I".repeat(Math.max(0, arabic));
    }
}
