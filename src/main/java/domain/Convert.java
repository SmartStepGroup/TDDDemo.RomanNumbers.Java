package domain;

public class Convert {
    private static DigitsMap digitsMap = new DigitsMap();

    public static String toRoman(int arabicNumber) {
        String romanNumber = getRawRomanNumber(arabicNumber);
        romanNumber = fix4DigitsInRow(romanNumber);
        romanNumber = fix2InterlacingNumbers(romanNumber);
        return romanNumber;
    }

    private static String fix4DigitsInRow(String romanNumber) {
        for (int i = 3; i < romanNumber.length(); i++) {
            if (romanNumber.charAt(i - 3) == romanNumber.charAt(i) &&
                    romanNumber.charAt(i - 2) == romanNumber.charAt(i) &&
                    romanNumber.charAt(i - 1) == romanNumber.charAt(i)
            ) {
                romanNumber = romanNumber.substring(0, i - 3) +
                        romanNumber.charAt(i) +
                        digitsMap.getNextRomanDigit(romanNumber.charAt(i)) +
                        romanNumber.substring(i + 1);
            }
        }
        return romanNumber;
    }

    private static String fix2InterlacingNumbers(String romanNumber) {
        for (int i = 2; i < romanNumber.length(); i++) {
            boolean has2InterlacedDigits = romanNumber.charAt(i - 2) == romanNumber.charAt(i) && romanNumber.charAt(i - 1) != romanNumber.charAt(i);
            if (has2InterlacedDigits) {
                romanNumber = romanNumber.substring(0, i - 2) +
                        romanNumber.charAt(i - 1) +
                        digitsMap.getNextRomanDigit(romanNumber.charAt(i)) +
                        romanNumber.substring(i + 1);
            }
        }
        return romanNumber;
    }

    private static String getRawRomanNumber(int arabicNumber) {
        String romanNumber = "";
        for (Integer digit : digitsMap.getArabicDigits()) {
            while (arabicNumber >= digit) {
                romanNumber += digitsMap.getRomanDigits(digit);
                arabicNumber -= digit;
            }
        }
        return romanNumber;
    }
}
