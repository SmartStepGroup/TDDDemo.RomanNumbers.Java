package viewModels;

import domain.ArabicToRomanNumberConverter;

public class ArabicToRomanConverterViewModel {
    private boolean convertButtonEnabled = false;
    private String arabicNumber;
    private String romanNumber;
    private ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
    private String errorMessage;

    public boolean isConvertButtonEnabled() {
        return convertButtonEnabled;
    }

    public void setArabicNumber(String arabicNumber) {
        if (arabicNumber.equals("")) {
            error("");
            return;
        }

        if (!arabicNumber.matches("\\d+")) {
            error("Only digits please");
            return;
        }

        happy(arabicNumber);
    }

    private void happy(String arabicNumber) {
        this.arabicNumber = arabicNumber;
        errorMessage = "";
        convertButtonEnabled = true;
    }

    private void error(String errorMessage) {
        convertButtonEnabled = false;
        this.errorMessage = errorMessage;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public void convert() {
        romanNumber = converter.Convert(Integer.parseInt(arabicNumber));
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
