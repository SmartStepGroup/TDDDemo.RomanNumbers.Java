package backup;

public class ArabicToRomanNumberConverter {
    private ArabicToRomanDigitMap map = new ArabicToRomanDigitMap();

    public String Convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        if (noNumber)
            return getDefaultRomanNumber();

        String romanNumber = getRoughRomanNumber(arabicNumber);
        romanNumber = replace4IdenticalNumbersInRow(romanNumber);
        romanNumber = replace2InterlacingNumbers(romanNumber);
        return romanNumber;
    }

    private String getRoughRomanNumber(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        for (Digit digit : map) {
            while (arabicNumber >= digit.arabic) {
                romanNumber.append(digit.roman);
                arabicNumber -= digit.arabic;
            }
        }

        return romanNumber.toString();
    }

    private String replace4IdenticalNumbersInRow(String romanNumber) {
        for (int i = 3; i < romanNumber.length(); i++) {
            boolean containsFourIdenticalDigitsInRow = romanNumber.charAt(i - 3) == romanNumber.charAt(i - 2) &&
                    romanNumber.charAt(i - 2) == romanNumber.charAt(i - 1) &&
                    romanNumber.charAt(i - 1) == romanNumber.charAt(i);
            if (containsFourIdenticalDigitsInRow) {
                Character nextRomanNumber = map.getNextRomanNumber(romanNumber.charAt(i));
                romanNumber = romanNumber.substring(0, i - 2) +
                        nextRomanNumber +
                        romanNumber.substring(i + 1);
            }
        }
        return romanNumber;
    }

    private String replace2InterlacingNumbers(String romanNumber) {
        for (int i = 2; i < romanNumber.length(); i++) {
            boolean contains2InterlacingDigits =
                    romanNumber.charAt(i - 2) == romanNumber.charAt(i) &&
                    romanNumber.charAt(i - 1) != romanNumber.charAt(i);
            if (contains2InterlacingDigits) {
                romanNumber = romanNumber.substring(0, i - 2) +
                        romanNumber.charAt(i - 1) +
                        map.getNextRomanNumber(romanNumber.charAt(i)) +
                        romanNumber.substring(i + 1);
            }
        }
        return romanNumber;
    }

    private String getDefaultRomanNumber() {
        return "";
    }
}
