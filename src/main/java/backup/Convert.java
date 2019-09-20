package backup;

public class Convert {
    private static DigitsMap2 digitsMap = new DigitsMap2();

    public static String toRoman(int arabic) {
        var rawRomanNumber = getRawRoman(arabic);
        return fixFourCharacters(rawRomanNumber);
    }

    private static String fixFourCharacters(String roman) {
        for (int i = 3; i < roman.length(); i++) {
            if (roman.charAt(i - 3) == roman.charAt(i - 2) &&
                    roman.charAt(i - 3) == roman.charAt(i - 1) &&
                    roman.charAt(i - 3) == roman.charAt(i)) {
                return roman.substring(0, i - 3) + roman.charAt(i) + digitsMap.nextRoman(roman.charAt(i)) + roman.substring(i + 1);
            }
        }

        return roman;
    }

    private static String getRawRoman(int arabic) {
        for (int i = 0; i < digitsMap.size(); i++) {
            int arabicDigit = digitsMap.arabicDigit(i);
            char romanDigit = digitsMap.romanDigit(i);
            if (arabicDigit <= arabic) {
                return romanDigit + getRawRoman(arabic - arabicDigit);
            }
        }

        return "";
    }
}
